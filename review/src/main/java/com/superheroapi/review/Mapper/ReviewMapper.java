package com.superheroapi.review.Mapper;

import com.superheroapi.review.Dto.ReviewDto;
import com.superheroapi.review.models.Review;

public class ReviewMapper {
    public static ReviewDto MappingToDto(Review review){
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(reviewDto.getStars());
        reviewDto.setTitle(reviewDto.getTitle());

        return reviewDto;


    } public static Review MappingToEntity(ReviewDto reviewDto){
        Review review = new Review();

        review.setId(reviewDto.getId());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        review.setTitle(reviewDto.getTitle());

        return review;


    }
}
