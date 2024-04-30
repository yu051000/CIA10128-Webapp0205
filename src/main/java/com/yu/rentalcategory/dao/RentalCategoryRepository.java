// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

package com.yu.rentalcategory.dao;

import com.yu.rentalcategory.entity.RentalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCategoryRepository extends JpaRepository<RentalCategory, Integer> {

}