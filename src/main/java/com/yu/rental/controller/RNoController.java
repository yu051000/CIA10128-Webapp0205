//package com.yu.rental.controller;
//
//import com.yu.rental.entity.Rental;
//import com.yu.rental.model.RentalServiceImpl;
//import com.yu.rentalcategory.entity.RentalCategory;
//import com.yu.rentalcategory.model.RentalCategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import java.util.List;
//import java.util.Set;
//
//@RestController //包含@Controller功能，並於當前控制器的所有方法加入@ResponseBody功能。數據通過HttpServletResponse輸出給瀏覽器，請求方法。
//    @Validated
//    @RequestMapping("/rental")
//    public class RNoController {
//
//        @Autowired
//        RentalServiceImpl rentalSvc;
//
//        @Autowired
//        RentalCategoryService rentalcategorySvc;
//
//        /*
//         * This method will be called on select_page.html form submission, handling POST
//         * request It also validates the user input
//         */
//        @PostMapping("getOne_For_Display")
//        public String getOne_For_Display(
//                /***************************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//                @NotEmpty(message="租借品編號: 請勿空白")
//                @Digits(integer = 10, fraction = 0, message = "租借品編號: 請填數字-請勿超過{integer}位數")
//                @Min(value = 5001, message = "租借品編號: 不能小於{value}")
//                @Max(value = 8000, message = "租借品編號: 不能超過{value}")
//                @RequestParam("rNo") String rNo,
//                ModelMap model) {
//
//            /***************************2.開始查詢資料*********************************************/
//            Rental rental = rentalSvc.getOneRental(Integer.valueOf(rNo));
//
//            List<Rental> list = rentalSvc.getAll();
//            model.addAttribute("rentalListData", list);     // for select_page.html 第97 109行用
//            model.addAttribute("rentalcategory", new RentalCategory());  // for select_page.html 第133行用
//            List<RentalCategory> list2 = rentalcategorySvc.getAll();
//            model.addAttribute("rentalcategoryListData",list2);    // for select_page.html 第135行用
//
//            if (rental == null) {
//                model.addAttribute("errorMessage", "查無資料");
//                return "backend/rental/select_page";
//            }
//
//            /***************************3.查詢完成,準備轉交(Send the Success view)*****************/
//            model.addAttribute("rental", rental);
//            model.addAttribute("getOne_For_Display", "true"); // 旗標getOne_For_Display見select_page.html的第156行 -->
//
////		return "backend/rental/listOneRental";  // 查詢完成後轉交listOneEmp.html
//            return "backend/rental/select_page"; // 查詢完成後轉交select_page.html由其第158行insert listOneEmp.html內的th:fragment="listOneEmp-div
//        }
//
//
//        @ExceptionHandler(value = { ConstraintViolationException.class }) //該方法將處理指定的異常類型
//        //@ResponseStatus(value = HttpStatus.BAD_REQUEST) //異常發生時，應該返回的 HTTP 響應狀態碼
//        public ModelAndView handleError(HttpServletRequest req,ConstraintViolationException e,Model model) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            StringBuilder strBuilder = new StringBuilder();
//            for (ConstraintViolation<?> violation : violations ) {
//                strBuilder.append(violation.getMessage() + "<br>");
//            }
//            //==== 以下第92~96行是當前面第77行返回 /src/main/resources/trentallates/back-end/rental/select_page.html用的 ====
////	    model.addAttribute("rental", new Rental());
////    	RentalCategoryService rentalSvc = new RentalCategoryService();
//            List<Rental> list = rentalSvc.getAll();
//            model.addAttribute("rentalListData", list);     // for select_page.html 第97 109行用
//            model.addAttribute("rentalcategory", new RentalCategory());  // for select_page.html 第133行用
//            List<RentalCategory> list2 = rentalcategorySvc.getAll();
//            model.addAttribute("rentalcategoryListData",list2);    // for select_page.html 第135行用
//            String message = strBuilder.toString();
//            return new ModelAndView("backend/rental/select_page", "errorMessage", "請修正以下錯誤:<br>"+message);
//        }
//
//    }
