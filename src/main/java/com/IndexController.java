package com;

import com.yu.rental.model.RentalServiceImpl;
import com.yu.rentalcategory.model.RentalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

//控制器方法：定義方法處理請求
//Model表示模型，用來儲存數據。(最後放在HttpServletrequest作用域)

@Controller
public class IndexController {

//    @Autowired  // 自動裝配
//    RentalServiceImpl rentalSvc;
//    @Autowired  // 自動裝配
//    RentalCategoryService rentalCategorySvc;


////    @GetMapping("/rental/index") //接收Get請求，@RequestMapping(method=RequestMethod.GET)的簡化版
//    @RequestMapping("/rental/index") //指templates資料夾中的index.html
//    public String index(Model model) {
//
//        //調用service，處理請求，獲取數據
//    	model.addAttribute("title", "測試1");
//        model.addAttribute("time", LocalDateTime.now());
//        return "index";  //view (在index.html顯示數據)
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //ModelAndView  ----> springMVC 框架的快捷，提供表示數據+視圖
//
//    @GetMapping("/rental/select_page") //在method層面上用作處理 http 的請求。
//	public ModelAndView select_page() {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name", "select查詢");
//        mv.setViewName("select_page"); //選擇呈現的網頁
//        return mv;
//	}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//    //=========== 以下是提供給 /src/main/resources/trentallates/back-end/rental/select_page.html 與 listAll.html 要使用的資料 ===================
//
//    @GetMapping("/rental/select_page") //在method層面上用作處理 http 的請求。
//	public String select_page(Model model) {
//		return "backend/rental/select_page";
//	}
//
//    @GetMapping("/rental/listAllRental") //在method層面上用作處理 http 的請求。
//	public String listAllRental(Model model) {
//		return "backend/rental/listAllRental";
//	}
//
//
//    //因寫在方法上，故將此類別中的@GetMapping Method先加入model.addAttribute("...List",...Service.getAll());
//    @ModelAttribute("rentalListData")  //select_page.html、listAllEmp.html使用
//    protected List<Rental> referenceListData(Model model) {
//        List<Rental> list = rentalSvc.getAll();
//        return list;
//    }
//
//    //因寫在方法上，故將此類別中的@GetMapping Method先加入model.addAttribute("...List",...Service.getAll());
//    @ModelAttribute("rentalCategoryListData") //select_page.html 使用
//    protected List<RentalCategory> referenceListData_RentalCat(Model model) {
//        model.addAttribute("rentalCategory", new RentalCategory()); //select_page.html 使用
//        List<RentalCategory> list = rentalCategorySvc.getAll();
//        return list;
//    }
//
//

}