package com.yu.rental.service;

import com.yu.rental.entity.Rental;

import java.util.List;

public interface RentalService {

    public Rental getRentalName(String rentalName);//單筆查詢

    public Rental findByNo(Integer rentalNo);//單筆查詢

    public List<Rental> findAll();  //全部查詢(Rental)

    public List<Rental> searchRentals(Rental rental); //複合查詢

    public Rental addRental(Rental rental); //新增

    public Rental updateRental(Rental rental); //修改

    public Rental getOneRental(Integer rentalNo);

//    public List<RentalCategory> findAllRentalCat();  //全部查詢(RentalCategory)
}
