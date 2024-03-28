package com.sopra.microservices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sopra.microservices.Orders;

public interface Repo extends JpaRepository<Orders, Integer>{
	
	@Query(nativeQuery = true, value = "Select * from restaurant_orders where date between ? and ?")
	List<Orders> getOrdersWithinDate(java.sql.Date startDate, java.sql.Date endDate);

}
