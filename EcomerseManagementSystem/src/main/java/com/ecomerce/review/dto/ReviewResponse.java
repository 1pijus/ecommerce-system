package com.ecomerce.review.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponse {
	private int reviewId;
	private int productId;
	private int userId;
	private String comment;
    private LocalDateTime createdAt;
}
