package com.yu.rental.model;

import com.yu.rental.entity.Rental;

import java.util.List;

public interface RentalService {

    public Rental getRentalName(String rName);//單筆查詢
    public Rental findByNo(Integer rNo);//單筆查詢
    public List<Rental> findAll();  //萬用複合查詢



//    public Rental findByName(String rName);//單筆查詢
//    public List<Rental> getAllRentals(int currentPage); //查詢當前頁面
//
//    public List<Rental> getByCompositeQuery(Map<String, String[]> map); //複合查詢
//
//    public long getPageTotal();
}
