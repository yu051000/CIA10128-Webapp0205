package com.yu.rentalcategory.service;

import com.yu.rentalcategory.dao.RentalCategoryRepository;
import com.yu.rentalcategory.entity.RentalCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

    @Service
    public class RentalCategoryServiceImpl implements RentalCategoryService {

        @Autowired //自動裝配
        private RentalCategoryRepository repository;

        //單筆查詢
        @Override
        public RentalCategory findByCatNo(Integer rentalCatNo) {
            return repository.findByRentalCatNo(rentalCatNo);	}

        //單筆查詢
        @Override
        public RentalCategory getRentalCatName(String rentalCatName) {
            return repository.findByRentalCatName(rentalCatName);	}

        //單筆查詢
        @Override
        public RentalCategory getOneRentalCat(Integer rentalCatNo) {
            return repository.findByRentalCatNo(rentalCatNo);
        }

        //全部查詢(RentalCategory)
        @Override
        public List<RentalCategory> findAll() {
            return repository.findAll();
        }
        
        //修改 (PK有值，save方法修改數據)
        @Override
        public RentalCategory updateRentalCat(RentalCategory rentalCategory) {
            return repository.save(rentalCategory);
        }

        //新增 (PK為null，save方法插入數據)
        @Override
        public RentalCategory addRentalCat(RentalCategory rentalCategory) {
            return repository.save(rentalCategory);
        }

        //自定義查詢(for萬用)
        @Override
        public List<RentalCategory> searchRentalCats(RentalCategory rentalCategory) {
            Integer rentalCatNo = rentalCategory.getRentalCatNo();
            String rentalCatName = rentalCategory.getRentalCatName();
            BigDecimal rentalDesPrice = rentalCategory.getRentalDesPrice();
            Integer rentalStockQty = rentalCategory.getRentalStockQty();
            Integer rentalRentedQty = rentalCategory.getRentalRentedQty();

            try {
                if (rentalCatNo != null)
                    return repository.findQueryByRentalCatNo(rentalCatNo);

                else if (rentalCatName != null && rentalCatName.trim().isEmpty())
                    return repository.findQueryByRentalCatName(rentalCatName);

                else if (rentalDesPrice != null)
                    return repository.findQueryByRentalDesPrice(rentalDesPrice);

                else if (rentalStockQty != null)
                    return repository.findQueryByRentalStockQty(rentalStockQty);

                else if (rentalRentedQty != null)
                    return repository.findQueryByRentalRentedQty(rentalRentedQty);

                else
                    return repository.findAll(); // 如果沒有任何條件，返回所有使用者

            } catch (NullPointerException e) {
                System.out.println(e);
            }
            return null;
        }
    }
