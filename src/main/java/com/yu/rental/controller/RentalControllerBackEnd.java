package com.yu.rental.controller;

import com.yu.rental.entity.Rental;
import com.yu.rental.service.RentalServiceImpl;
import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalcategory.service.RentalCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/backend/rental") //對應資料夾路徑
public class RentalControllerBackEnd {

    @Autowired  // 自動裝配
    private RentalServiceImpl rentalService;
    @Autowired
    private RentalCategoryServiceImpl rentalCategoryService;


    //顯示 index.html
    @GetMapping("/index")
    public String home() {
        return "/backend/index";
    }

    //顯示後台 select_page.html
    @GetMapping("/selectPage") //處理 http get的請求。
    public String selectPage(@ModelAttribute("rental") Rental rental) {
        return "backend/rental/select_page";
    }

    //顯示後台 listAllRental.html
    @GetMapping("/listAllRental")
    public String listAllRental() {
        return "backend/rental/listAllRental";
    }

    //顯示後台 listOneRental.html
    @GetMapping("/listOneRental")  //required = true：請求參數不可為null(預設)
    public String getOneRental(@RequestParam(value = "rentalNo",required = true) Integer rentalNo, ModelMap model, HttpSession session) {
        //建立返回數據的對象
        Rental rental = rentalService.findByNo(rentalNo);
        model.addAttribute("rental", rental);
        return "backend/rental/listOneRental";
    }

    //顯示後台 addRental.html
    @GetMapping("/addRental")
    public String addRentalFrom(ModelMap model) {
        Rental rental = new Rental();
        model.addAttribute("rental", rental);
        return "/backend/rental/addRental";
    }


    //顯示後台 updateRental.html///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/updateRental")
    public String updateRental(Model model) {
        //建立返回數據的對象
        List<Rental> rentalList = rentalService.findAll();
        model.addAttribute("rental", rentalList);
        model.addAttribute("rentalCategory", rentalCategoryService.findAll());
        model.addAttribute("rental", rentalList.get(0));
        return "/backend/rental/updateRental";
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //處理查詢
    @PostMapping("getOne_For_Display")
    public String getOne_For_Display(@RequestParam("rentalNo") String rentalNo, ModelMap model) {

        Rental rental = rentalService.getOneRental(Integer.valueOf(rentalNo));
        List<Rental> list = rentalService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("rentalCategory", new RentalCategory());
        List<RentalCategory> rentalCatListData = rentalCategoryService.findAll();
        model.addAttribute("rentalCatListData",rentalCatListData);

        if (rental == null) {
            model.addAttribute("errorMessage", "查無資料");
            return "back-end/rental/select_page";
        }
        model.addAttribute("rental", rental);
        return "backend/rental/listOneRental"; // 查詢完成後轉交listOneRental.html
    }


    //處理複合查詢//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  方法一：
//    @PostMapping("search")
//    public String search(HttpServletRequest req, Model model) {  //@ModelAttribute ->　從View接收參數
//        //建立返回數據的對象
//        List<Rental> rentalList = rentalService.searchRentals(rental);
//        model.addAttribute("rentalList", rentalList);
//        return "backend/rental/listOneRental"; //結果傳至listOneRental
//    }

//  方法二：
    @PostMapping("search")
    public String searchRentals(@RequestBody Rental rental, RedirectAttributes attributes) {
        List<Rental> queryList = rentalService.searchRentals(rental);
        attributes.addFlashAttribute("queryList", queryList);
        return "redirect:/backend/rental/select_page";
    }
    @ModelAttribute("rentalquery") //select_page.html、listAllEmp.html使用
    protected List<Rental> referenceListData2() {
        List<Rental> rentalQuery = rentalService.findAll();
        return rentalQuery; //取得Rental列表
    }

    /**
     * 使用 POST 請求時，Http 協議就規定「前端要將參數放在 @RequestBody 中傳遞」 (json格式)
     *
     */
    //處理新增
    @PostMapping("addRental")
    public String addRental(@Valid Rental rental, BindingResult result, ModelMap model){
        if (result.hasErrors()) { //若有錯誤
            return "back-end/emp/addEmp";
        }
        rentalService.addRental(rental); //新增
        List<Rental> list = rentalService.findAll();
        model.addAttribute("list", list);
        return "redirect:/backend/rental/listAllRental"; // 新增成功後重導至IndexController_inSpringBoot.java的第58行@GetMapping("/emp/listAllEmp")

    }


//   測試無法新增(可能緩存問題)
//    @PostMapping("/addRental")
//    @ResponseBody
//    public ResponseEntity<?> addRental(@Valid @RequestBody Rental rental, BindingResult result, ModelMap model){
//        if (result.hasErrors()) { //若有錯誤
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation failed: " + result.getAllErrors());
//        }
//        rentalService.addRental(rental); //新增
//        return ResponseEntity.ok("/backend/rental/listAllRental"); //直接返回重定向網頁
//    }

//     其他驗證方式： 若屬性存在一個以上的驗證註解，為避免在驗證皆未通過。 搭配迴圈輸出完整的錯誤訊息
//            for(int i = 0, len = fieldErrors.size(); i < len; i++){
//                FieldError field = fieldErrors.get(i);
//                map.put(i + "-" + field.getField(), field.getDefaultMessage()); //出錯的名稱&訊息放入map。(Message是entity輸入的內容)
//            }
////            return map; //返回驗證出錯的原因&訊息


    //處理查詢
    @PostMapping("showAddRental")
    public String showAddRental(Rental rental, ModelMap model) {  //此處去掉RequestBody註解，直接獲得表單post數據
        if (rental == null) {
            return "/backend/rental/addRental"; //返回add頁面
        }
        rentalService.addRental(rental); //新增
        List<Rental> list = rentalService.findAll();
        model.addAttribute("list", list);
        return "backend/rental/listAllRental"; // 查詢完成後轉交listOneRental.html
    }

    //處理修改///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("update")
    public String updateRental(@Valid Rental rental, BindingResult result, ModelMap model){
        if (result.hasErrors()) { //若有錯誤
            model.addAttribute("rental", rental);
            model.addAttribute("errors", result.getAllErrors()); //取得驗證有出錯的屬性
            return "/backend/rental/updateRental";
        }
        // 將資料添加到 ModelMap 中
        rentalService.updateRental(rental);
        rental = rentalService.getOneRental(Integer.valueOf(rental.getRentalNo()));
        model.addAttribute("rental", rental);
        return "backend/rental/listOneRental";
    }

    //處理單筆修改///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("getOne_For_Update")
    public String getOne_For_Update(@RequestParam("rentalNo") String rentalNo, ModelMap model) {
        Rental rental = rentalService.getOneRental(Integer.valueOf(rentalNo));
        model.addAttribute("rental", rental);
        return "backend/rental/updateRental"; // 查詢完成後轉交update_rental.html
    }



    /**
     * 因 @ModelAttribute寫在方法上，故將此類別中的@GetMapping Method先加入model.addAttribute("...List",...Service.getAll());
     * referenceListData()：回傳一個包含參考資料的列表或映射，透過View渲染到使用者介面上。
     *
     * @return 與rentalNo對應的rental資料庫
     */
    @ModelAttribute("rentalData") // 以rentalNo搜索，取出對應的rental資料庫
    protected Rental referenceData(@RequestParam(value = "rentalNo", required = false) Integer rentalNo) {
        if (rentalNo != null) {
            Rental list = rentalService.findByNo(rentalNo);
            return list; //取得Rental列表
        }
        return null;
    }


    /**
     * 提供所有租借品資料列表供視圖渲染使用。
     * 使用 @ModelAttribute 註解，確保在處理請求時可用於視圖中的 productList 屬性。
     * referenceListData()：回傳一個包含參考資料的列表或映射，透過View渲染到使用者介面上。
     *
     * @return RentalCategory列表。
     */
    @ModelAttribute("rentalCatListData")
    protected Map<Integer, String> referenceMapData() {
        Map<Integer, String> map = new LinkedHashMap<>();

        // 添加部門數據，每個數字對應一個空字符串
        for (int i = 1; i <= 100; i++) {
            map.put(i, ""); // 或者可以指定其他預設值，例如"未知部門"
        }
        return map;
    }


    /**
     * 因 @ModelAttribute寫在方法上，故將此類別中的@GetMapping Method先加入model.addAttribute("...List",...Service.getAll());
     * referenceListData()：回傳一個包含參考資料的列表或映射，透過View渲染到使用者介面上。
     *
     * @return rental所有資料庫
     */
    @ModelAttribute("rentalListData") //取出rental資料庫
    protected List<Rental> referenceListData() {
        List<Rental> rentalList = rentalService.findAll();
        return rentalList; //取得Rental列表
    }


}