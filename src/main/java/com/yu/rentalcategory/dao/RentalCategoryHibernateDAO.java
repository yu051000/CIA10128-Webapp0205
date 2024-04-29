package com.yu.rentalcategory.dao;

import java.math.BigDecimal;
import java.util.Map;
import java.util.List;
import com.Entity.RentalCategory;

public interface RentalCategoryHibernateDAO {

    int add(RentalCategory RentalCategory);  //若是使用Boolean，即可判斷是否有新增成功

    int update(RentalCategory RentalCategory); //修改

    int delete(Integer rCatNo); //刪除

    RentalCategory getByPK(Integer rCatNo); //使用PK去搜尋處理

    RentalCategory getByName(String rCatName); //搜尋類別名稱

    RentalCategory getByDesPrice(BigDecimal rDesPrice); //搜尋押金

    List<RentalCategory> getAll(); //萬用複合查詢

    List<RentalCategory> getByCompositeQuery(Map<String, String> map); //複合查詢

    List<RentalCategory> getAllRentalCats(int currentPage); //查詢當前頁面

    int getPageTotal();
}