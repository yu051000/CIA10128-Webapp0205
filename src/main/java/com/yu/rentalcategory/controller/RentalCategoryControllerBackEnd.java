package com.yu.rentalcategory.controller;

import com.yu.rental.service.RentalServiceImpl;
import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalcategory.service.RentalCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/backend/rentalcategory") //對應資料夾路徑
public class RentalCategoryControllerBackEnd {

	@Autowired  // 自動裝配
	private RentalServiceImpl rentalService;
	@Autowired
	private RentalCategoryServiceImpl rentalCategoryService;


	//顯示 index.html
	@GetMapping("/index")
	public String home() {
		return "/backend/index";
	}
	




	// 顯示後台 select_rentalCategory_page.html
	@GetMapping("/selectPage")
	public String selectPage(@ModelAttribute("rentalCategory") RentalCategory rentalCategory) {
		return "backend/rentalcategory/select_rentalCategory_page"; //傳至select_rentalCategory_page.html
	}
	
	//顯示後台 listAllRentalCategory.html
	@GetMapping("/listAllRentalCategory")
	public String listAllRentalCategory() {
		return "backend/rentalcategory/listAllRentalCategory";
	}
	
	
	//顯示後台 listOneRental.html
	@GetMapping("/listOneRentalCat")  //required = true：請求參數不可為null(預設)
	public String listOneRentalCat(@RequestParam(value="rentalCatNo", required = true) Integer rentalCatNo, ModelMap model, HttpSession session) {
		//建立返回數據的對象
		RentalCategory rentalCategory = rentalCategoryService.findByCatNo(rentalCatNo);
		model.addAttribute("rentalCategory", rentalCategory);
		return "backend/rentalcategory/listOneRentalCategory";
	}


	//顯示後台 addRental.html
	@GetMapping("/addRentalCategory")
	public String addRentalCategory(@ModelAttribute("rentalCategory") RentalCategory rentalCategory) {
		return "/backend/rentalcategory/addRentalCategory";
	}


	// 前往更新商品頁面
//	@GetMapping("/updateRentalCategory")
//	public String updateRentalCategory(Model model) {
//		List<RentalCategory> rentalCatList =rentalCategoryService.findAll();
//		model.addAttribute("rentalCatList", rentalCatList);
//		model.addAttribute("rentalCategory", rentalCategoryService.findAll());
//		model.addAttribute("product", rentalCatList.get(0));
//		return "/backend/rentalcategory/updateRentalCategory";
//	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//處理查詢
@PostMapping("getOne_For_Display")
public String getOne_For_Display(@RequestParam("rentalCatNo") String rentalCatNo, ModelMap model) {

	RentalCategory rentalCategory = rentalCategoryService.getOneRentalCat(Integer.valueOf(rentalCatNo));
	List<RentalCategory> list = rentalCategoryService.findAll();
	model.addAttribute("list", list);
	model.addAttribute("rentalCategory", new RentalCategory());
	List<RentalCategory> rentalCatListData = rentalCategoryService.findAll();
	model.addAttribute("rentalCatListData",rentalCatListData);

	if (rentalCategory == null) {
		model.addAttribute("errorMessage", "查無資料");
		return "back-end/rental/select_rentalCategory_page";
	}
	model.addAttribute("rentalCategory", rentalCategory);
	return "backend/rental/listOneRentalCategory"; // 查詢完成後轉交listOneRental.html
}


	// 處理新增資料
	@PostMapping("/backend/rentalcategory/addRentalCategory")
	public String addRentalCategory(@Valid @RequestBody RentalCategory rentalCategory, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("rentalCategory", rentalCategory);
			model.addAttribute("errors", result.getAllErrors());
			return"/backend/rentalcategory/addRentalCategory";
		}
		rentalCategoryService.addRentalCat(rentalCategory);

		// 將資料添加到 ModelMap 中
		List<RentalCategory> list = rentalCategoryService.findAll();
		model.addAttribute("list", list);
		return "redirect:/backend/rentalcategory/listAllRentalCategory";
	}


	// 處理修改資料
	@PostMapping("/backend/rentalcategory/updateRentalCategory")
	public String updateRentalCategory(@Valid RentalCategory rentalCategory, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("rentalCategory", rentalCategory);
			model.addAttribute("errors", result.getAllErrors());
			return"/backend/rentalcategory/updateRentalCategory";
		}
		rentalCategoryService.addRentalCat(rentalCategory);
		return "redirect:/backend/rentalcategory/listAllRentalCategory";
	}

	//處理單筆修改
	@PostMapping("/getOne_For_Update")
	public String getOne_For_Update(@RequestParam(value="rentalCatNo") Integer rentalCatNo, BindingResult result, ModelMap model) {

			RentalCategory rentalCategory = rentalCategoryService.findByCatNo(rentalCatNo);
			model.addAttribute("rentalCategory", rentalCategory);
			return "backend/rentalcategory/updateRentalCategory"; // 查詢完成後轉交update_rental_input.html
		}


	//處理複合查詢
//	@PostMapping("search")
//	public String search(@ModelAttribute RentalCategory rentalCategory, Model model) {
//		//建立返回數據的對象
//		List<RentalCategory> rentalCatList = rentalCategoryService.searchRentalCats(rentalCategory);
//		model.addAttribute("rentalCatList", rentalCatList);
//		return "backend/rentalcategory/listOneRentalCategory"; //結果傳至listOneRentalCategory
//	}





	/**
	 * 提供所有租借品資料列表供視圖渲染使用。
	 * 使用 @ModelAttribute 註解，確保在處理請求時可用於視圖中的 productList 屬性。
	 * referenceListData()：回傳一個包含參考資料的列表或映射，透過View渲染到使用者介面上。
	 *
	 * @return RentalCategory列表。
	 */
	@ModelAttribute("rentalCatListData")
	protected List<RentalCategory> referenceListData() {
		List<RentalCategory> rentalCatList =rentalCategoryService.findAll();
		return rentalCatList;
	}









}