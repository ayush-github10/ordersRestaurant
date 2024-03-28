package com.sopra.microservices.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.microservices.Orders;

@Service
public interface Services {
	
	public Orders add(Orders or);
	
	public Orders getOrderDetails(int orderId);
	
	void update(Orders or);
	
	List<Orders> getOrdersWithinDate(java.sql.Date startDate, java.sql.Date endDate);

}
