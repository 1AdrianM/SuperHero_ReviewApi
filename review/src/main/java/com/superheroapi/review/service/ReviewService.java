package com.superheroapi.review.service;

import com.superheroapi.review.Dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);
     List<ReviewDto> getReviewsbyId(int id);
    ReviewDto getReviews(ReviewDto reviewDto);
    ReviewDto updateReviews(ReviewDto reviewDto, int reviewId, int heroId);
    ReviewDto deleteReviews(ReviewDto reviewDto, int id);
}
