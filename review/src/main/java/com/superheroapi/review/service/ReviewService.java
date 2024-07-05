package com.superheroapi.review.service;

import com.superheroapi.review.Dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto, int HeroId);
     List<ReviewDto> getReviewsByHeroId(int id);
    ReviewDto getReviewById(ReviewDto reviewDto, int id);
    ReviewDto updateReviews(ReviewDto reviewDto, int reviewId, int heroId);
    void deleteReviews(ReviewDto reviewDto, int id);
}
