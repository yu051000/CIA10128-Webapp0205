package com.yu.rentalcategory.dao;

import com.Entity.RentalCategory;
import java.util.*;

public interface RentalCategoryDAO_interface {
    public void insert(RentalCategory RentalCategory); //新增

    public void update(RentalCategory RentalCategory); //修改

    public void delete(Integer rCatNo); //刪除

    public RentalCategory findByPrimaryKey(Integer rCatNo); //查詢

    public List<RentalCategory> getAll(); //萬用複合查詢(傳入參數型態Map)(回傳 List)
}