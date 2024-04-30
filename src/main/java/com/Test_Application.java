package com;

import com.yu.rental.entity.Rental;
import com.yu.rental.dao.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

//	CommandLineRunner以String 陣列包裝參數； ApplicationRunner則是ApplicationArguments(有系統地取出資料內容)

@SpringBootApplication //開啟自動配置。相當於宣告@Configuration、@ComponentScan、@EnableAutoConfiguration
public class Test_Application implements CommandLineRunner {

	@Autowired  // 自動裝配RentalRepository
	RentalRepository repository ;

	public static void main(String[] args) {
        SpringApplication.run(Test_Application.class);
    }

    @Override
    public void run(String...args) throws Exception {

//    	//● 新增
//		Rental Rental = new Rental(); // 部門POJO
////		Rental.setRentalCategoryno(1);
//
//		Rental Rental1 = new Rental();
//		Rental1.setrName("禮服");
//		Rental1.setrPrice(new BigDecimal(12000));
//		Rental1.setrSize(2);
//		Rental1.setrColor("藍色");
//		Rental1.setrInfo(valueOf(1));
////		Rental1.setRental(Rental);
//		repository.save(Rental1);
//
//		//● 修改
//		Rental Rental2 = new Rental();
//		Rental2.setrNo(5001);
//		Rental2.setrName("禮服");
//		Rental1.setrPrice(new BigDecimal(16000));
//		Rental1.setrSize(2);
//		Rental1.setrColor("藍色");
//		Rental1.setrInfo(valueOf(1));
////		Rental2.setRentalCategory(Rental);
//		repository.save(Rental2);

    	//● 查詢-findByPrimaryKey (多方rental2.hbm.xml必須設為lazy="false")(優!)
    	Optional<Rental> optional = repository.findById(5003);
		Rental Rental3 = optional.get();
		System.out.print(Rental3.getrNo() + ",");
		System.out.print(Rental3.getrName() + ",");
		System.out.print(Rental3.getrPrice() + ",");
		System.out.print(Rental3.getrSize() + ",");
		System.out.print(Rental3.getrColor() + ",");
		System.out.print(Rental3.getrInfo() + ",");
//		// 注意以下三行的寫法 (優!)
////		System.out.print(Rental3.getRental().getrCatNo() + ",");
////		System.out.print(Rental3.getRental().getrCatName() + ",");
//		System.out.println("\n---------------------");


		//● 查詢-getAll (多方rental2.hbm.xml必須設為lazy="false")(優!)
//    	List<Rental> list = repository.findAll();
//		for (Rental aRental : list) {
//			System.out.print(aRental.getrNo() + ",");
//			System.out.print(aRental.getrName() + ",");
//			System.out.print(aRental.getrPrice() + ",");
//			System.out.print(aRental.getrSize() + ",");
//			System.out.print(aRental.getrColor() + ",");
//			System.out.print(aRental.getrInfo() + ",");
			// 注意以下三行的寫法 (優!)
//			System.out.print(aRental.getRental().getrCatNo() + ",");
//			System.out.print(aRental.getRental().getrCatName() + ",");
//			System.out.print(aRental.getRental().getLoc());
//			System.out.println();
		}


//		//● 複合查詢-getAll(map) 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("rNo", new String[] { "7001" });
//		map.put("rName", new String[] { "KING" });
//		map.put("rPrice", new String[] { "PRESIDENT" });
//		map.put("rColor", new String[] { "1981-11-17" });
//		map.put("rSize", new String[] { "5000.5" });
//		map.put("rColor", new String[] { "0.0" });
//		map.put("rCatNo", new String[] { "1" });
//
//		List<Rental> list2 = HibernateUtil_CompositeQuery_Rental3.getAllC(map,sessionFactory.openSession());
//		for (Rental aRental : list2) {
//			System.out.print(aRental.getrNo() + ",");
//			System.out.print(aRental.getrName() + ",");
//			System.out.print(aRental.getrPrice() + ",");
//			System.out.print(aRental.getrSize() + ",");
//			System.out.print(aRental.getrColor() + ",");
//			System.out.print(aRental.getrInfo() + ",");
//			// 注意以下三行的寫法 (優!)
//			System.out.print(aRental.getRental().getrCatNo() + ",");
//			System.out.print(aRental.getRental().getrCatName() + ",");
//			System.out.print(aRental.getRental().getLoc());
//			System.out.println();
//		}

//    }
}
