package com.sopra.microservices;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="restaurant_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	@Id
	 int orderId;
	 String items;
	 int price;
	 @Temporal(TemporalType.DATE)
	 Date date;
	 @Enumerated(EnumType.ORDINAL)
	 private OrderStatus ord;
	 
	

}
