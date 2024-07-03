package com.superheroapi.review.service.Implementation;

import com.superheroapi.review.Dto.ReviewDto;
import com.superheroapi.review.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewImplementation implements ReviewService {
    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        return null;
    }

    @Override
    public List<ReviewDto> getReviewsbyId(int id) {
        return List.of();
    }

    @Override
    public ReviewDto getReviews(ReviewDto reviewDto) {
        return null;
    }

    @Override
    public ReviewDto updateReviews(ReviewDto reviewDto, int reviewId, int heroId) {
        return null;
    }

    @Override
    public ReviewDto deleteReviews(ReviewDto reviewDto, int id) {
        return null;
    }
}
