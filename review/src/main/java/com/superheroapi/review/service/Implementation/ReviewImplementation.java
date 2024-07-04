package com.superheroapi.review.service.Implementation;

import com.superheroapi.review.Dto.ReviewDto;
import com.superheroapi.review.exceptions.SuperHeroNotFoundException;
import com.superheroapi.review.models.Review;
import com.superheroapi.review.models.SuperHero;
import com.superheroapi.review.repository.ReviewRepository;
import com.superheroapi.review.repository.SuperHeroRepository;
import com.superheroapi.review.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewImplementation implements ReviewService {
    private  final ReviewRepository reviewRepository;
  private final SuperHeroRepository superHeroRepository;
    public ReviewImplementation(ReviewRepository reviewRepository, SuperHeroRepository superHeroRepository) {
        this.reviewRepository = reviewRepository;
        this.superHeroRepository = superHeroRepository;
    }

   //Override
  /*lic ReviewDto createReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setStart(reviewDto.getStart());
        review.setContent(reviewDto.getContent());

        Review newReview = reviewRepository.save(review);
        ReviewDto reviewResponse = new ReviewDto();
        newReview.setId(reviewResponse.getId());
        newReview.setTitle(reviewResponse.getTitle());
        newReview.setStart(reviewResponse.getStart());
        newReview.setContent(review.getContent());

        return MappingToDto(newReview);
    }
*/
    @Override
    public ReviewDto createReview(ReviewDto reviewDto, int HeroId) {
        Review review = MappingToEntity(reviewDto);
        SuperHero hero = superHeroRepository.findById(HeroId).orElseThrow(()->  new SuperHeroNotFoundException("ID Not FOUND"));
        //review.setHero(hero); Reparar
        Review newReview = reviewRepository.save(review);
       return MappingToDto(newReview);

    }

    @Override
    public List<ReviewDto> getReviewsbyHeroId(int id) {
        List<Review> reviewDtoList = reviewRepository.findHerobyId(id);

        return reviewDtoList.stream().map(r -> MappingToDto(r)).collect(Collectors.toList());
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
    public ReviewDto MappingToDto(Review review){
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setContent(review.getContent());
        reviewDto.setStart(reviewDto.getStart());
        reviewDto.setTitle(reviewDto.getTitle());

        return reviewDto;


    } public Review MappingToEntity(ReviewDto reviewDto){
        Review review = new Review();

        review.setId(reviewDto.getId());
        review.setContent(reviewDto.getContent());
        review.setStart(reviewDto.getStart());
        review.setTitle(reviewDto.getTitle());

        return review;


    }
}
