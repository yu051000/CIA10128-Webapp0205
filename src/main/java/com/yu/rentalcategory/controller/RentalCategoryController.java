//package com.yu.rentalcategory.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import com.yu.rental.model.Rental;
//import org.springframework.validation.BeanPropertyBindingResult;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.io.IOException;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import com.yu.rentalcategory.model.RentalCategory;
//import com.yu.rentalcategory.model.RentalCategoryService;
//
//@Controller
//@RequestMapping("/rentalcategory")
//public class RentalCategoryController {
//
//	@Autowired
//	RentalCategoryService rentalcategorySvc;
//
//	/*
//	 * This method will serve as addRentalCategory.html handler.
//	 */
//	@GetMapping("addRentalCategory")
//	public String addRentalCategory(ModelMap model) {
//		RentalCategory rentalCategoryVO = new RentalCategory();
//		model.addAttribute("rentalCategoryVO", rentalCategoryVO);
//		return "backend/rentalCategory/addRentalCategory";
//	}
//
//	/*
//	 * This method will be called on addRentalCategory.html form submission, handling POST request It also validates the user input
//	 */
//	@PostMapping("insert")
//	public String insert(@Valid RentalCategory rentalCategoryVO, BindingResult result, ModelMap model) throws IOException {
//
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//		if (result.hasErrors()) {
//			return "backend/rental/addRentalCategory";
//		}
//		/*************************** 2.開始新增資料 *****************************************/
//		rentalcategorySvc.addRentalCat(rentalCategoryVO);
//		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
//		List<RentalCategory> list = rentalcategorySvc.getAll();
//		model.addAttribute("rentalcategoryListData", list);
//		model.addAttribute("success", "- (新增成功)");
//		return "redirect:/rentalcategory/listAllRentalCategory"; // 新增成功後重導至IndexController_inSpringBoot.java的第58行@GetMapping("/rental/listAllRentalCategory")
//	}
//
//	/*
//	 * This method will be called on listAllRentalCategory.html form submission, handling POST request
//	 */
//	@PostMapping("getOne_For_Update")
//	public String getOne_For_Update(@RequestParam("rCatNo") String rCatNo, ModelMap model) {
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//		/*************************** 2.開始查詢資料 *****************************************/
//		RentalCategory RentalCategory = rentalcategorySvc.getOneRentalCat(Integer.valueOf(rCatNo));
//
//		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
//		model.addAttribute("RentalCategory", RentalCategory);
//		return "backend/rentalcategory/update_rentalcategory_input"; // 查詢完成後轉交update_rental_input.html
//	}
//
//	/*
//	 * This method will be called on update_rental_input.html form submission, handling POST request It also validates the user input
//	 */
//	@PostMapping("update")
//	public String update(@Valid RentalCategory RentalCategory, BindingResult result) throws IOException {
//
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//		if (result.hasErrors()) {
//			return "backend/rentalcategory/update_rentalcategory_input";
//		}
//		/*************************** 2.開始修改資料 *****************************************/
//		rentalcategorySvc.updateRentalCat(RentalCategory);
//
//		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
//		model.addAttribute("success", "- (修改成功)");
//		RentalCategory = rentalcategorySvc.getOneRentalCat(Integer.valueOf(RentalCategory.getrCatNo()));
//		model.addAttribute("RentalCategory", RentalCategory);
//		return "backend/rentalcategory/listOneRentalCategory"; // 修改成功後轉交listOneRentalCategory.html
//	}
//
//	/*
//	 * This method will be called on listAllRentalCategory.html form submission, handling POST request
//	 */
////	@PostMapping("delete")
////	public String delete(@RequestParam("rCatNo") String rCatNo, ModelMap model) {
////		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
////		/*************************** 2.開始刪除資料 *****************************************/
////		// RentalCategoryService rentalcategorySvc = new RentalCategoryService();
////		rentalcategorySvc.deleteRental(Integer.valueOf(rCatNo));
////		/*************************** 3.刪除完成,準備轉交(Send the Success view) **************/
////		List<RentalCategory> list = rentalcategorySvc.getAll();
////		model.addAttribute("rentalcategoryListData", list);
////		model.addAttribute("success", "- (刪除成功)");
////		return "backend/rental/listAllRentalCategory"; // 刪除完成後轉交listAllRentalCategory.html
////	}
//
//
//	// 去除BindingResult中某個欄位的FieldError紀錄
//	public BindingResult removeFieldError(RentalCategory rentalCategoryVO, BindingResult result, String removedFielrCatName) {
//		List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
//				.filter(fielrCatName -> !fielrCatName.getField().equals(removedFielrCatName))
//				.collect(Collectors.toList());
//		result = new BeanPropertyBindingResult(rentalCategoryVO, "rentalCategoryVO");
//		for (FieldError fieldError : errorsListToKeep) {
//			result.addError(fieldError);
//		}
//		return result;
//	}
//
//	/*
//	 * This method will be called on select_page.html form submission, handling POST request
//	 */
//	@PostMapping("listRentalCats_ByCompositeQuery")
//	public String listRentalCats_ByCompositeQuery(HttpServletRequest req, Model model) {
//		Map<String, String[]> map = req.getParameterMap();
//		List<RentalCategory> list = rentalcategorySvc.getAll(map);
//		model.addAttribute("rentalcategoryListData", list); // for listAllRentalCategory.html 第85行用
//		return "backend/rentalcategory/listAllRentalCategory";
//	}
//
//}