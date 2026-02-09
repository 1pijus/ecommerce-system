package com.ecomerce.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.review.dto.ReviewRequest;
import com.ecomerce.review.dto.ReviewResponse;
import com.ecomerce.review.entity.ReviewEntity;
import com.ecomerce.review.exception.ReviewAlreadyExistsException;
import com.ecomerce.review.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	ReviewEntity reviewEntity = new ReviewEntity();
	
	public ReviewResponse addReview(ReviewRequest reviewRequest) {
		boolean  alreadyReviewed= reviewRepository.existsByProductIdAndUserId(reviewRequest.getProductId(),reviewRequest.getUserId());
		
		if(alreadyReviewed) {
			throw new ReviewAlreadyExistsException("User already reviewed this product!");
		}
		
		reviewEntity.setProductId(reviewRequest.getProductId());
		reviewEntity.setUserId(reviewRequest.getUserId());
		reviewEntity.setComment(reviewRequest.getComment());
		
		reviewEntity = reviewRepository.save(reviewEntity);
		
		return mapToResponse(reviewEntity);
	}
	
	public ReviewResponse mapToResponse(ReviewEntity entity) {
		ReviewResponse reviewResponse = new ReviewResponse();
		
		reviewResponse.setReviewId(entity.getReviewId());
		reviewResponse.setProductId(entity.getProductId());
		reviewResponse.setUserId(entity.getUserId());
		reviewResponse.setComment(entity.getComment());
		reviewResponse.setCreatedAt(entity.getCreatedAt());
		return reviewResponse;
	}
	
	public List<ReviewResponse> getReviewByProduct(int productId) {
		List<ReviewEntity> reviews = reviewRepository.findByProductId(productId);
		if(reviews.isEmpty()) {
			throw new RuntimeException("Product is not Present on this id "+productId);
		}
		
		return reviews.stream().map(this :: mapToResponse).toList();
	}
}
