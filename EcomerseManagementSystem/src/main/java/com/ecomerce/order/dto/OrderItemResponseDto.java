package com.ecomerce.order.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemResponseDto {

    private Integer productId;
	private Integer quantity;
	private Double price;
}
