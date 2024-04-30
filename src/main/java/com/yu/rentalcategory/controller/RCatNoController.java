//package com.rental.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.*;
//import com.rental.model.Rental;
//import com.rental.model.RentalCategoryService;
//
//
//@Controller
//@Validated
//@RequestMapping("/rental")
//public class RCatNoController {
//
//	@Autowired
//	RentalCategoryService rentalSvc;
//
//	@Autowired
//    com.rentalcategory.model.RentalCategoryService rentalcategorySvc;
//
//	/*
//	 * This method will be called on select_page.html form submission, handling POST
//	 * request It also validates the user input
//	 */
//	@PostMapping("getOne_For_Display")
//	public String getOne_For_Display(
//		/***************************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//		@NotEmpty(message="租借品編號: 請勿空白")
//		@Digits(integer = 4, fraction = 0, message = "租借品編號: 請填數字-請勿超過{integer}位數")
//		@Min(value = 7001, message = "租借品編號: 不能小於{value}")
//		@Max(value = 7777, message = "租借品編號: 不能超過{value}")
//		@RequestParam("rNo") String rNo,
//		ModelMap model) {
//
//		/***************************2.開始查詢資料*********************************************/
////		RentalCategoryService rentalSvc = new RentalCategoryService();
//		Rental Rental = rentalSvc.getOneRental(Integer.valueOf(rNo));
//
//		List<Rental> list = rentalSvc.getAll();
//		model.addAttribute("rentalListData", list);     // for select_page.html 第97 109行用
//		model.addAttribute("Rental", new Rental());  // for select_page.html 第133行用
//		List<Rental> list2 = rentalcategorySvc.getAll();
//    	model.addAttribute("rentalcategoryListData",list2);    // for select_page.html 第135行用
//
//		if (Rental == null) {
//			model.addAttribute("errorMessage", "查無資料");
//			return "back-end/rental/select_page";
//		}
//
//		/***************************3.查詢完成,準備轉交(Send the Success view)*****************/
//		model.addAttribute("Rental", Rental);
//		model.addAttribute("getOne_For_Display", "true"); // 旗標getOne_For_Display見select_page.html的第156行 -->
//
////		return "back-end/rental/listOneRental";  // 查詢完成後轉交listOneRental.html
//		return "back-end/rental/select_page"; // 查詢完成後轉交select_page.html由其第158行insert listOneRental.html內的th:fragment="listOneRental-div
//	}
//
//
//	@ExceptionHandler(value = { ConstraintViolationException.class })
//	//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public ModelAndView handleError(HttpServletRequest req,ConstraintViolationException e,Model model) {
//	    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//	    StringBuilder strBuilder = new StringBuilder();
//	    for (ConstraintViolation<?> violation : violations ) {
//	          strBuilder.append(violation.getMessage() + "<br>");
//	    }
//	    //==== 以下第92~96行是當前面第77行返回 /src/main/resources/trentallates/back-end/rental/select_page.html用的 ====
////	    model.addAttribute("Rental", new Rental());
////    	RentalCategoryService rentalSvc = new RentalCategoryService();
//		List<Rental> list = rentalSvc.getAll();
//		model.addAttribute("rentalListData", list);     // for select_page.html 第97 109行用
//		model.addAttribute("Rental", new Rental());  // for select_page.html 第133行用
//		List<Rental> list2 = rentalcategorySvc.getAll();
//    	model.addAttribute("rentalcategoryListData",list2);    // for select_page.html 第135行用
//		String message = strBuilder.toString();
//	    return new ModelAndView("back-end/rental/select_page", "errorMessage", "請修正以下錯誤:<br>"+message);
//	}
//
//}