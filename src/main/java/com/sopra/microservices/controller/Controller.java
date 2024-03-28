package com.sopra.microservices.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.microservices.OrderStatus;
import com.sopra.microservices.Orders;
import com.sopra.microservices.services.ServicesImplementation;

@RestController
@RequestMapping("/orders")
public class Controller {
	
	@Autowired
	private ServicesImplementation ser;
	
	@PostMapping
	public ResponseEntity<Void> add(@RequestBody Orders or){
		ser.add(or);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	@GetMapping("/get/{orderId}")
	public ResponseEntity<Orders> getOrderDetails(@PathVariable("orderId") int orderId){
		Orders or=ser.getOrderDetails(orderId);
		return new ResponseEntity<>(or,HttpStatus.OK);
		
	}
	@PutMapping("/update")
	public ResponseEntity<String> or(@RequestBody OrderStatus or,int orderId){
		Orders ord=ser.getOrderDetails(orderId);
		ord.setOrd(or);
		ser.update(ord);
		return new ResponseEntity<>("Updated",HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyDate/{startDate}/{endDate}")
	public ResponseEntity<List<Orders>> getOrdersWithinDate(@PathVariable java.sql.Date startDate,@PathVariable java.sql.Date endDate ){
		List<Orders> lst=ser.getOrdersWithinDate(startDate, endDate);
		return new ResponseEntity<List<Orders>>(lst,HttpStatus.OK);
		
	}
	
	

}
