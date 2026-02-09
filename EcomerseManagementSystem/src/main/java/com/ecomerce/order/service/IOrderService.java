package com.ecomerce.order.service;

import com.ecomerce.order.dto.OrderItemRequestDto;
import com.ecomerce.order.dto.OrderRequestDto;
import com.ecomerce.order.dto.OrderResponseDto;

public interface IOrderService {

	public OrderResponseDto placeOrder(OrderRequestDto request);
	
}
