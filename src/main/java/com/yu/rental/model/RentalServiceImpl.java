package com.yu.rental.model;

import com.yu.rental.dao.RentalRepository;
import com.yu.rental.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired //自動裝配
	private RentalRepository repository;


	//單筆查詢
	@Override
	public Rental findByNo(Integer rNo) {
		return repository.findByrNo(rNo);	}


	//單筆查詢
	@Override
	public Rental getRentalName(String rName) {
		return repository.findByrName(rName);	}

	//全部查詢
	@Override
	public List<Rental> findAll() {
		return repository.findAll();
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