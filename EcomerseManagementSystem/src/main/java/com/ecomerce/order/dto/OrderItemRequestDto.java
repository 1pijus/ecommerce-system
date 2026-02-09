package com.ecomerce.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemRequestDto {
	
 @NotNull(message = "Product id is required")
 private  Integer productId;
 
 @NotNull(message = "Quantity is required")
 @Min(value = 1,message = "Quantity must be at least 1")
 private Integer quantity;
 
 @NotNull(message = "Price is required")
 @Positive(message = "price must be greater than 0")
 private double price;
 
	
}
