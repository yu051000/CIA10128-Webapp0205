// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

package com.yu.rental.dao;

import com.yu.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}