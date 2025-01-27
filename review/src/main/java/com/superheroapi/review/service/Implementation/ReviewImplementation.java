package com.superheroapi.review.service.Implementation;

import com.superheroapi.review.Dto.ReviewDto;
import com.superheroapi.review.Mapper.ReviewMapper;
import com.superheroapi.review.exceptions.ReviewNotFoundException;
import com.superheroapi.review.exceptions.SuperHeroNotFoundException;
import com.superheroapi.review.models.Review;
import com.superheroapi.review.models.SuperHero;
import com.superheroapi.review.repository.ReviewRepository;
import com.superheroapi.review.repository.SuperHeroRepository;
import com.superheroapi.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.superheroapi.review.Mapper.ReviewMapper.MappingToDto;
import static com.superheroapi.review.Mapper.ReviewMapper.MappingToEntity;

@Service
public class ReviewImplementation implements ReviewService {
    @Autowired
    private  final ReviewRepository reviewRepository;
  private final SuperHeroRepository superHeroRepository;

    public ReviewImplementation(ReviewRepository reviewRepository, SuperHeroRepository superHeroRepository) {
        this.reviewRepository = reviewRepository;
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto, int HeroId) {
        Review review = MappingToEntity(reviewDto);
        SuperHero hero = superHeroRepository.findById(HeroId).orElseThrow(()->  new SuperHeroNotFoundException("ID Not FOUND"));
        review.setSuperHero(hero);
        Review newReview = reviewRepository.save(review);
       return MappingToDto(newReview);

    }

    @Override
    public List<ReviewDto> getReviewsByHeroId(int id) {
        List<Review> reviewList = reviewRepository.findSuperHeroById(id);

        return reviewList.stream().map(ReviewMapper::MappingToDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDto getReviewById(int reviewId,  int  heroId) {
         Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("Not found id"));
SuperHero superHero = superHeroRepository.findById(heroId).orElseThrow(()-> new SuperHeroNotFoundException("Not found super hero by  this  id"));
if (review.getSuperHero().getId() != superHero.getId()){
    throw new ReviewNotFoundException("Ids Didnt match");
}
return MappingToDto(review);

    }
    // Tomando Nota las comparaciones  de id   seran  lo mas popular en esta clase
    @Override
    public ReviewDto updateReviews(ReviewDto reviewDto, int reviewId, int heroId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("Not found id"));
        SuperHero superHero = superHeroRepository.findById(heroId).orElseThrow(()-> new SuperHeroNotFoundException("Not found super hero by  this  id"));
        if (review.getSuperHero().getId() != superHero.getId()){
            throw new ReviewNotFoundException("Ids Didnt match");
        }
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        Review updatedReview = reviewRepository.save(review);
        return MappingToDto(updatedReview);
        //Mas tarde extrae ambos Id  comparalos y luego inserte el actualizado en el  modelo atra ves del dto luego save
    }

    @Override
    public void deleteReviews(int reviewId, int heroId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("Not found id"));
        SuperHero superHero = superHeroRepository.findById(heroId).orElseThrow(()-> new SuperHeroNotFoundException("Not found super hero by  this  id"));
        if (review.getSuperHero().getId() != superHero.getId()){
            throw new ReviewNotFoundException("Ids Didnt match");
        }
        reviewRepository.delete(review);

    }

}
