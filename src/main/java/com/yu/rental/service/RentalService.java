package com.yu.rental.service;

import com.yu.rental.entity.Rental;

import java.util.List;
import java.util.Map;

public interface RentalService {

    public Rental getRentalName(String rentalName);//單筆查詢
    public Rental findByNo(Integer rentalNo);//單筆查詢
    public List<Rental> findAll();  //全部查詢
    public List<Rental> getByCompositeQuery(Map<String, String[]> map); //複合查詢


//    public Rental findByName(String rentalName);//單筆查詢
//    public List<Rental> getAllRentals(int currentPage); //查詢當前頁面
//    public long getPageTotal();
}
