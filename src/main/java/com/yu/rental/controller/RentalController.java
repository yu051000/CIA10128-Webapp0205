package com.yu.rental.controller;

import javax.validation.Valid;


import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.yu.rental.entity.Rental;
import com.yu.rental.model.RentalService;
import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalcategory.model.RentalCategoryService;

@Controller
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    RentalService rentalSvc;

    @Autowired
    RentalCategoryService rentalcategorySvc;

    /*
     * This method will serve as addRental.html handler.
     */
    @GetMapping("/addRental")
    public String addRental(ModelMap model) {
        Rental rental = new Rental();
        model.addAttribute("rental", rental);
        return "backend/rental/addRental"; //返回網頁
    }

    /*
     * This method will be called on addRental.html form submission, handling POST request It also validates the user input
     */
    @PostMapping("insert")
    public String insert(@Valid Rental rental, BindingResult result, ModelMap model) throws IOException {

        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
        if (result.hasErrors()) {
            return "backend/rental/addRental";
        }
        /*************************** 2.開始新增資料(永續層) *****************************************/
        rentalSvc.addRental(rental);
        /*************************** 3.新增完成,準備轉交(Send the Success view) **************/
        List<Rental> list = rentalSvc.getAll();
        model.addAttribute("rentalListData", list);
        model.addAttribute("success", "- (新增成功)");
        return "redirect:/rental/listAllRental"; // 新增成功後重導至IndexController_inSpringBoot.java的第58行@GetMapping("/rental/listAllRental")
    }

    /*
     * This method will be called on listAllRental.html form submission, handling POST request
     */
    @PostMapping("getOne_For_Update")
    public String getOne_For_Update(@RequestParam("rNo") String rNo, ModelMap model) {
        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
        /*************************** 2.開始查詢資料 *****************************************/
        Rental rental = rentalSvc.getOneRental(Integer.valueOf(rNo));

        /*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
        model.addAttribute("rental", rental);
        return "backend/rental/update_rental_input"; // 查詢完成後轉交update_rental_input.html
    }

    /*
     * This method will be called on update_rental_input.html form submission, handling POST request It also validates the user input
     */
    @PostMapping("update")
    public String update(@Valid Rental rental, BindingResult result, ModelMap model) throws IOException {

        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
        // 去除BindingResult中upFiles欄位的FieldError紀錄 --> 見第172行
//        result = removeFieldError(rental, result, "upFiles");

        if (result.hasErrors()) {
            return "backend/rental/update_rental_input";
        }
        /*************************** 2.開始修改資料 *****************************************/
        // RentalCategoryService rentalSvc = new RentalCategoryService();
        rentalSvc.updateRental(rental);

        /*************************** 3.修改完成,準備轉交(Send the Success view) **************/
        model.addAttribute("success", "- (修改成功)");
        rental = rentalSvc.getOneRental(Integer.valueOf(rental.getrNo()));
        model.addAttribute("rental", rental);
        return "backend/rental/listOneRental"; // 修改成功後轉交listOneRental.html
    }

    /*
     * 第一種作法 Method used to populate the List Data in view. 如 :
     * <form:select path="rCatNo" id="rCatNo" items="${rentalcategoryListData}" itemValue="rCatNo" itemLabel="rCatName" />
     */
    @ModelAttribute("rentalListData")
    protected List<Rental> referenceListData() {
        // RentalCategoryService rentalcategorySvc = new RentalCategoryService();
        List<Rental> list = rentalSvc.getAll();
        return list;
    }

    /*
     * 【 第二種作法 】 Method used to populate the Map Data in view. 如 :
     * <form:select path="rCatNo" id="rCatNo" items="${rentalcategoryMapData}" />
     */
    @ModelAttribute("rentalcategoryMapData") //
    protected Map<Integer, String> referenceMapData() {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "西裝");
        map.put(2, "婚紗");
        map.put(3, "禮服");
        return map;
    }

    // 去除BindingResult中某個欄位的FieldError紀錄
    public BindingResult removeFieldError(Rental rental, BindingResult result, String removedFielrCatName) {
        List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
                .filter(fielrCatName -> !fielrCatName.getField().equals(removedFielrCatName))
                .collect(Collectors.toList());
        result = new BeanPropertyBindingResult(rental, "rental");
        for (FieldError fieldError : errorsListToKeep) {
            result.addError(fieldError);
        }
        return result;
    }

    /*
     * This method will be called on select_page.html form submission, handling POST request
     */
    //複合查詢
//    @PostMapping("listRentals_ByCompositeQuery")
//    public String listRentals_ByCompositeQuery(HttpServletRequest req, Model model) {
//        Map<String, String[]> map = req.getParameterMap();
//        List<Rental> list = rentalSvc.getAll(map);
//        model.addAttribute("rentalListData", list); // for listAllRental.html 第85行用
//        return "backend/rental/listAllRental";
//    }


    //    @PostMapping("delete")
//    public String delete(@RequestParam("rNo") String rNo, ModelMap model) {
//        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//        /*************************** 2.開始刪除資料 *****************************************/
//        // RentalCategoryService rentalSvc = new RentalCategoryService();
//        rentalSvc.deleteRental(Integer.valueOf(rNo));
//        /*************************** 3.刪除完成,準備轉交(Send the Success view) **************/
//        List<Rental> list = rentalSvc.getAll();
//        model.addAttribute("rentalListData", list);
//        model.addAttribute("success", "- (刪除成功)");
//        return "backend/rental/listAllRental"; // 刪除完成後轉交listAllRental.html
//    }
}