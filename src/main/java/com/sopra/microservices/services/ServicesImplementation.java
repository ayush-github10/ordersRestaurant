package com.sopra.microservices.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.microservices.Orders;
import com.sopra.microservices.repository.Repo;

@Service
public class ServicesImplementation implements Services{
	
	@Autowired
	private Repo repo;

	@Override
	public Orders add(Orders or) {
		return repo.save(or);
	}

	@Override
	public Orders getOrderDetails(int orderId) {
		Optional<Orders> op=repo.findById(orderId);
		return op.get();
	}

	@Override
	public void update(Orders or) {
		repo.save(or);
		
	}

	@Override
	public List<Orders> getOrdersWithinDate(java.sql.Date startDate, java.sql.Date endDate) {
		List<Orders> lst= repo.getOrdersWithinDate(startDate, endDate);
		return lst;
	}

}
