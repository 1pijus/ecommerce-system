package com.ecomerce.review.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
	@NotNull(message = "Product id is required")
	private int productId;
	@NotNull(message = "User id is Required")
	private int userId;
	@NotNull(message = "Review comment can  not be empty")
	private String comment;
}
