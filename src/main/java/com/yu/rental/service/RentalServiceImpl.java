package com.yu.rental.service;

import com.yu.rental.dao.RentalRepository;
import com.yu.rental.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired //自動裝配
	private RentalRepository repository;


	//單筆查詢
	@Override
	public Rental findByNo(Integer rentalNo) {
		return repository.findByRentalNo(rentalNo);	}


	//單筆查詢
	@Override
	public Rental getRentalName(String rentalName) {
		return repository.findByRentalName(rentalName);	}

	//全部查詢
	@Override
	public List<Rental> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Rental> getByCompositeQuery(Map<String, String[]> map) {
		return null;
	}

	//	//新增 (PK為null，save方法插入數據)
//	public Rental addRental(Rental rental) {
//		return repository.save(rental);
//	}
//
//	//修改 (PK有值，save方法修改數據)
//	public Rental updateRental(Rental rental) {
//		return repository.save(rental);
//	}

}