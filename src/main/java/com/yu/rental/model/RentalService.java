package com.yu.rental.model;

import java.util.List;
import java.util.Optional;

import com.yu.rental.dao.RentalRepository;
import com.yu.rental.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rentalService")
public class RentalService {

	@Autowired
    RentalRepository repository;

	//新增
	public void addRental(Rental rental) {
		repository.save(rental);
	}

	//修改
	public void updateRental(Rental rental) {
		repository.save(rental);
	}

	//單筆查詢(PK)
	public Rental getOneRental(Integer rNo) {
		Optional<Rental> optional = repository.findById(rNo);
//		return optional.get();
		return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
	}
	
	//全部查詢
	public List<Rental> getAll() {
		return repository.findAll();
	}

	/*
	//若須刪除可使用
	public void deleteRental(Integer rNo) {
	if (repository.existsById(rNo))
		repository.deleteById(rNo);
	}
	*/
}