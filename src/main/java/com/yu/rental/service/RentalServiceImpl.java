package com.yu.rental.service;

import com.yu.rental.dao.RentalRepository;
import com.yu.rental.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired //自動裝配
	private RentalRepository repository;

	//單筆查詢
	@Override
	public Rental findByNo(Integer rentalNo) {
//		添加邏輯判斷是否有查詢到資料.
		return repository.findByRentalNo(rentalNo);	}

	//單筆查詢
	@Override
	public Rental getRentalName(String rentalName) {
		return repository.findByRentalName(rentalName);	}

	//全部查詢(Rental)
	@Override
	public List<Rental> findAll() {
		return repository.findAll();
	}


//	//全部查詢(RentalCategory)
//	@Override
//	public List<RentalCategory> findAllRentalCat() {
//		return repository.findAllRentalCat();
//	}

	//修改 (PK有值，save方法修改數據)
	@Override
	public Rental updateRental(Rental rental) {
		return repository.save(rental);
	}

	//單筆查詢
	@Override
	public Rental getOneRental(Integer rentalNo) {
		return repository.findByRentalNo(rentalNo);
	}

	//新增 (PK為null，save方法插入數據)
	@Override
	public Rental addRental(Rental rental) {
		return repository.save(rental);
	}

	//自定義查詢(for萬用)
	@Override
	public List<Rental> searchRentals(Rental rental) {
		Integer rentalNo = rental.getRentalNo();
		String rentalName = rental.getRentalName();
		BigDecimal rentalPrice = rental.getRentalPrice();
		Integer rentalSize = rental.getRentalSize();
		String rentalInfo = rental.getRentalInfo();
		Byte rentalStat = rental.getRentalStat();
		String rentalColor = rental.getRentalColor();

		try {
			if (rentalNo != null)
				return repository.findQueryByRentalNo(rentalNo);

			else if (rentalName != null && rentalName.trim().isEmpty())
				return repository.findQueryByRentalName(rentalName);

			else if (rentalPrice != null)
				return repository.findQueryByRentalPrice(rentalPrice);

			else if (rentalSize != null)
				return repository.findQueryByRentalSize(rentalSize);

			else if (rentalColor != null && rentalName.trim().isEmpty())
				return repository.findQueryByRentalColor(rentalColor);

			else if (rentalInfo != null && rentalName.trim().isEmpty())
				return repository.findQueryByRentalInfo(rentalInfo);

			else if (rentalStat != null)
				return repository.findQueryByRentalStat(rentalStat);

			else
				return repository.findAll(); // 如果沒有任何條件，返回所有使用者

		} catch (NullPointerException e) {
			System.out.println(e);
		}
		return null;
	}
}