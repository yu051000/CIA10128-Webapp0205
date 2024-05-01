package com.yu.rental.controller;

import com.yu.rental.entity.Rental;
import com.yu.rental.model.RentalService;
import com.yu.rentalcategory.model.RentalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/backend/rental")
public class RentalController {

    @Autowired  // 自動裝配
    private RentalService rentalService;
    @Autowired  // 自動裝配
    private RentalCategoryService rentalCategoryService;



    //顯示所有租借品
    @GetMapping("/rentallist")
    public String getRentalList(ModelMap modelMap) {
        return "backend/rental/listAllRental";
    }

    @ModelAttribute("rentalListData")
    //referenceListData()：回傳一個包含參考資料的列表或映射，透過View渲染到使用者介面上。
    protected List<Rental> referenceListData() {
        List<Rental> list = rentalService.findAll();
        return list;
    }


    //顯示單筆租借品
    @GetMapping("/getOneRental")  //required = true：請求參數不可為null(預設)
    public String getOneRental(@RequestParam(value = "rNo",required = true) Integer rNo, ModelMap model) {
        //處理表單數據
        //建立返回數據的對象
        Rental rental = rentalService.findByNo(rNo);
        model.addAttribute("rental", rental);
        return "backend/rental/listOneRental";
    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //需要驗證的參數加上 @Valid 註解。若驗證失敗拋出例外 or 404狀態碼
//    @PostMapping("/rental") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
//    public ResponseEntity<Rental> getRental(@Valid @RequestBody Rental rental){
//        return ResponseEntity.ok().body(rental); //驗證rental全部
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @PostMapping("/rental/add") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public Map<String,Object> addRental(@Validated(Rental.AddRentalGroup.class) @RequestBody Rental rental, BindingResult result){
//
//        //service方法處理業務邏輯
//
//        //返回結果數據
//        Map<String,Object> map = new HashMap<>(); //儲存驗證結果的內容
//        if (result.hasErrors()) { //若有錯誤、未通過
//            List<FieldError> fieldErrors = result.getFieldErrors(); //取得驗證有出錯的屬性，放入list
//
//            // 若屬性存在一個以上的驗證註解，為避免在驗證皆未通過。 可搭配迴圈輸出完整的錯誤訊息
//            for(int i = 0, len = fieldErrors.size(); i < len; i++){
//                FieldError field = fieldErrors.get(i);
//                map.put(i + "-" + field.getField(), field.getDefaultMessage()); //出錯的名稱&訊息放入map。(Message是entity輸入的內容)
//            }
//        }
//        return map; //返回驗證出錯的原因&訊息
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//@PostMapping("/rental/update") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
////@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//public Map<String,Object> updateRental(@Validated(Rental.UpdateRentalGroup.class) @RequestBody Rental rental, BindingResult result){
//
//    //service方法處理業務邏輯
//
//    //返回結果數據
//    Map<String,Object> map = new HashMap<>(); //儲存驗證結果的內容
//    if (result.hasErrors()) { //若有錯誤、未通過
//        List<FieldError> fieldErrors = result.getFieldErrors(); //取得驗證有出錯的屬性，放入list
//
//        // 若屬性存在一個以上的驗證註解，為避免在驗證皆未通過。 可搭配迴圈輸出完整的錯誤訊息
//        for(int i = 0, len = fieldErrors.size(); i < len; i++){
//            FieldError field = fieldErrors.get(i);
//            map.put(i + "-" + field.getField(), field.getDefaultMessage()); //出錯的名稱&訊息放入map。(Message是entity輸入的內容)
//        }
//    }
//    return map; //返回驗證出錯的原因&訊息
//}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @PostMapping("getOne_For_Update") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public String getOne_For_Update(@RequestParam("rNo") String rNo, ModelMap model) {
//        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//        /*************************** 2.開始查詢資料 *****************************************/
//        Rental rental = rentalService.getOneRental(Integer.valueOf(rNo));
//
//        /*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
//        model.addAttribute("rental", rental);
//        return "backend/rental/update_rental_input"; // 查詢完成後轉交update_rental_input.html
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @GetMapping("/rental/select_page") //在method層面上用作處理 http 的請求。
//    public ModelAndView select_page() { //ModelAndView  --> springMVC 框架的快捷，提供表示數據+視圖
//        ModelAndView mv = new ModelAndView();
//        Rental rental = new Rental(); //建立一個Rental物件
////        mv.addObject("name", "select查詢");
//        mv.setViewName("select_page"); //選擇呈現的網頁
//        return mv;
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @GetMapping("/rental/addRental") //接收Get請求，對應的URI由當前方法處理
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public String addRental(Model model) {
//        Rental rental = new Rental();
//        model.addAttribute("rental", rental); //調用service，處理請求，獲取數據
//        return "addRental";  //view (在addRental.html顯示數據)
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    @PostMapping("insert") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public String insert(@Valid Rental rental, BindingResult result, ModelMap model) throws IOException {
//
//        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//        if (result.hasErrors()) {
//            return "backend/rental/addRental";
//        }
//        /*************************** 2.開始新增資料 *****************************************/
//        rentalService.addRental(rental);
//        /*************************** 3.新增完成,準備轉交(Send the Success view) **************/
//        List<Rental> list = rentalService.findAll();
//        model.addAttribute("rentalListData", list);
//        model.addAttribute("success", "- (新增成功)");
//        return "redirect:/rental/listAllRental"; // 新增成功後重導至IndexController_inSpringBoot.java的第58行@GetMapping("/rental/listAllRental")
//    }
//
//
//    @PostMapping("update") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public String update(@Valid Rental rental, BindingResult result, ModelMap model) throws IOException {
//
//        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//        // 去除BindingResult中upFiles欄位的FieldError紀錄 --> 見第172行
////        result = removeFieldError(rental, result, "upFiles");
//
//        if (result.hasErrors()) {
//            return "backend/rental/update_rental_input";
//        }
//        /*************************** 2.開始修改資料 *****************************************/
//        // RentalCategoryService rentalService = new RentalCategoryService();
//        rentalService.updateRental(rental);
//
//        /*************************** 3.修改完成,準備轉交(Send the Success view) **************/
//        model.addAttribute("success", "- (修改成功)");
//        rental = rentalService.getOneRental(Integer.valueOf(rental.getrNo()));
//        model.addAttribute("rental", rental);
//        return "backend/rental/listOneRental"; // 修改成功後轉交listOneRental.html
//    }
//
//    @ModelAttribute("rentalListData")
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    protected List<Rental> referenceListData() {
//        // RentalCategoryService rentalcategorySvc = new RentalCategoryService();
//        List<Rental> list = rentalService.findAll();
//        return list; //控制器方法返回值，響應給瀏覽器做展示
//    }

//    // 去除BindingResult中某個欄位的FieldError紀錄
//    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public BindingResult removeFieldError(Rental rental, BindingResult result, String removedFielrCatName) {
//        List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
//                .filter(fielrCatName -> !fielrCatName.getField().equals(removedFielrCatName))
//                .collect(Collectors.toList());
//        result = new BeanPropertyBindingResult(rental, "rental");
//        for (FieldError fieldError : errorsListToKeep) {
//            result.addError(fieldError);
//        }
//        return result; //控制器方法返回值，響應給瀏覽器做展示
//    }

    //複合查詢
//    @PostMapping("listRentals_ByCompositeQuery") //接收Http Post請求，這種請求通常用於創建新資源或提交資料給伺服器。
    //@ResponseBody---> 設為@RestController的預設加入。接受前端傳遞的json格式參數
//    public String listRentals_ByCompositeQuery(HttpServletRequest req, Model model) {
//        Map<String, String[]> map = req.getParameterMap();
//        List<Rental> list = rentalService.findAll(map);
//        model.addAttribute("rentalListData", list); // for listAllRental.html 第85行用
//        return "backend/rental/listAllRental";
//    }

}