//package com.yu.rentalcategory.service;
//
//import com.yu.util.HibernateUtil;
//import com.yu.rentalcategory.dao.DAO;
//import com.yu.rentalcategory.dao.RentalCategoryDAO_interface;
//import com.yu.rentalcategory.model.RentalCategory;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//public class RentalCategoryService {
//
//    private RentalCategoryDAO_interface dao;
//
//    public RentalCategoryService() {
////        dao = new RentalCategoryJDBCDAO();
//        dao = new DAO();
//    }
//
//    // 新增商品(將前端request值放入VO由DAO執行SQL語法，並返回VO由Controller轉給View)
//    public RentalCategory addRentalCategory(String rCatName, Integer rStockQty, Integer rRentedQty, BigDecimal rDesPrice) {
//
//        RentalCategory RentalCategory = new RentalCategory();
//
//        RentalCategory.setrCatName(rCatName);
//        RentalCategory.setrStockQty(rStockQty);
//        RentalCategory.setrRentedQty(rRentedQty);
//        RentalCategory.setrDesPrice(rDesPrice);
//        dao.insert(RentalCategory);// 將VO放入DAO的方法內執行資料庫操作
//
//        return RentalCategory;
//    }
//
//    //修改
//    public RentalCategory updateRentalCategory(Integer rCatNo,String rCatName, Integer rStockQty, Integer rRentedQty, BigDecimal rDesPrice) {
//
//        RentalCategory RentalCategory = new RentalCategory();
//
//        RentalCategory.setrCatNo(rCatNo);
//        RentalCategory.setrCatName(rCatName);
//        RentalCategory.setrStockQty(rStockQty);
//        RentalCategory.setrRentedQty(rRentedQty);
//        RentalCategory.setrDesPrice(rDesPrice);
//
//        return dao.findByPrimaryKey(rCatNo);
//    }
//
//    //刪除
//    public void deleteRentalCategory(Integer rCatNo) {
//        dao.delete(rCatNo);
//    }
//
//    //單筆查詢(PK)
//    public RentalCategory getOneRentalCategory(Integer rCatNo) {
//        return dao.findByPrimaryKey(rCatNo);
//    }
//
//    //查詢全部
//    public List<RentalCategory> getAll() {
//        return dao.getAll();
//    }
//}