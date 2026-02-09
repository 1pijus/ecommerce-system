package com.ecomerce.order.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.order.dto.OrderRequestDto;
import com.ecomerce.order.dto.OrderResponseDto;
import com.ecomerce.order.service.IOrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final IOrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<OrderResponseDto> placeOrder(@Valid @RequestBody OrderRequestDto request)
	{
		 
		OrderResponseDto response=orderService.placeOrder(request);
		
		return new ResponseEntity<OrderResponseDto>(response,HttpStatus.CREATED);
	}
	
}
