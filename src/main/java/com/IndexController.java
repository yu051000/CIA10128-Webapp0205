package com;

import com.yu.rental.entity.Rental;
import com.yu.rental.model.RentalService;
import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalcategory.model.RentalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;


//@PropertySource("classpath:application.properties") // 於https://start.spring.io建立Spring Boot專案時, application.properties文件預設已經放在我們的src/main/resources 目錄中，它會被自動檢測到
@Controller
public class IndexController {

    @Autowired  // 自動裝配RentalService
    RentalService rentalSvc;

    @Autowired  // 自動裝配RentalCategoryService
    RentalCategoryService rentalCategorySvc;


    @Value("${welcome.message}")
    private String message;
    private List<String> myList = Arrays.asList("官網 : https://start.spring.io");

    @GetMapping("/") //在method層面上用作處理 http 的請求。配合@RequestMapping使用
    public String index(Model model) {

    	model.addAttribute("message", message); //取得 @Value("${welcome.message}")。放在index
        model.addAttribute("myList", myList); //取得 "官網 : https://start.spring.io"。放在index
        return "index"; //view
    }

    // http://......../hello?name=peter1
    @GetMapping("/hello")
    public String indexWithParam(
            //@RequestParam： 在class層面上配合@GetMapping使用。(將web請求參數映射到方法參數上)
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);
        return "index"; //view
    }


    //=========== 以下是提供給 /src/main/resources/trentallates/back-end/rental/select_page.html 與 listAll.html 要使用的資料 ===================

    @GetMapping("/rental/select_page") //在method層面上用作處理 http 的請求。
	public String select_page(Model model) {
		return "backend/rental/select_page";
	}

    @GetMapping("/rental/listAllRental") //在method層面上用作處理 http 的請求。
	public String listAllRental(Model model) {
		return "backend/rental/listAllRental";
	}


    //因寫在方法上，故將此類別中的@GetMapping Method先加入model.addAttribute("...List",...Service.getAll());
    @ModelAttribute("rentalListData")  //select_page.html、listAllEmp.html使用
    protected List<Rental> referenceListData(Model model) {
        List<Rental> list = rentalSvc.getAll();
        return list;
    }

    //因寫在方法上，故將此類別中的@GetMapping Method先加入model.addAttribute("...List",...Service.getAll());
    @ModelAttribute("rentalCategoryListData") //select_page.html 使用
    protected List<RentalCategory> referenceListData_RentalCat(Model model) {
        model.addAttribute("rentalCategory", new RentalCategory()); //select_page.html 使用
        List<RentalCategory> list = rentalCategorySvc.getAll();
        return list;
    }
    //====RentalCategory==============================================================================================================================================




}