package com.ecomerce.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.review.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{
	boolean existsByProductIdAndUserId(int productId, int userId);
	List<ReviewEntity> findByProductId(int productId);
}
