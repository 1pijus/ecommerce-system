package com.ecomerce.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.review.dto.ReviewRequest;
import com.ecomerce.review.dto.ReviewResponse;
import com.ecomerce.review.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/created")
	public ResponseEntity<ReviewResponse> addReview(@Valid @RequestBody ReviewRequest reviewRequest){
		ReviewResponse reviewResponse = reviewService.addReview(reviewRequest);
		return new ResponseEntity<>(reviewResponse, HttpStatus.CREATED);
	}
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable int productId){
		return ResponseEntity.ok(
				reviewService.getReviewByProduct(productId));
	}
}
