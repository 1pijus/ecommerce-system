package com.ecomerce.order.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequestDto {
  @NotNull(message = "User id is Required")
  private Integer userId;	
	
  @NotEmpty(message="Order must Contain at least one item ")
  private List<OrderItemRequestDto>items;
}
