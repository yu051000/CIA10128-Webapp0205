package com.yu.rentalcategory.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.Entity.RentalCategory;

public interface RentalCategoryService_Interface {

    RentalCategory addRentalCat(String rCatName, Integer rStockQty, Integer rRentedQty, BigDecimal rDesPrice);

    RentalCategory updateRentalCat(Integer rCatNo,String rCatName, Integer rStockQty, Integer rRentedQty, BigDecimal rDesPrice);

    void deleteRentalCat(Integer rCatNo);

    RentalCategory getOneRentalCat(Integer rCatNo);//單筆查詢(PK)

    RentalCategory getOneRentalrCatName(String rCatName); //單筆查詢(類別名稱)

    RentalCategory getOneRentalrDesPrice(BigDecimal rDesPrice); //單筆查詢(押金)

    List<RentalCategory> getAll();  //萬用複合查詢

    List<RentalCategory> getAllRentalCats(int currentPage); //查詢當前頁面

    List<RentalCategory> getByCompositeQuery(Map<String, String[]> map); //複合查詢



    int getPageTotal();
}
