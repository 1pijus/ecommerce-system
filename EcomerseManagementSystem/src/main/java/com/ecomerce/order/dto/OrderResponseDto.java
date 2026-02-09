package com.ecomerce.order.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.ecomerce.order.entity.OrderItem;
import com.ecomerce.order.enums.OrderStatus;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class OrderResponseDto {

	private Integer orderid;
    private Integer userId;
	private Double totalAmount;
	private OrderStatus status;
	
	private List<OrderItemResponseDto> items;
	
	
}
