package com.yu.rentalcategory.service;

import java.util.List;
import java.util.Optional;

import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalcategory.dao.RentalCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rentalcategoryService")
public class RentalCategoryService {

	@Autowired
    RentalCategoryRepository repository;

	public void addRentalCat(RentalCategory Rental) {
		repository.save(Rental);
	}

	public void updateRentalCat(RentalCategory Rental) {
		repository.save(Rental);
	}

	//單筆查詢(PK)
	public RentalCategory getOneRentalCat(Integer rCatNo) {
		Optional<RentalCategory> optional = repository.findById(rCatNo);
//		return optional.get();
		return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
	}

	//全部查詢
	public List<RentalCategory> getAll() {
		return repository.findAll();
	}

//	//透過名字查詢
//	public RentalCategory getOneRentalrCatName(String rCatName) {
//		return repository.getByName(rCatName);
//	}
//
//	//透過押金查詢
//	public RentalCategory getOneRentalrDesPrice(BigDecimal rDesPrice) {
//		return repository.getByDesPrice(rDesPrice);
//	}
//
//	public Set<RentalCategory> getRentalrCatsByCatNo(Integer rCatNo) {
//		return getOneRentalrCat(rCatNo).getRentalrCats();
//	}
}
