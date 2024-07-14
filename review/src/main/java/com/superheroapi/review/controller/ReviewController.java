package com.superheroapi.review.controller;

import com.superheroapi.review.Dto.ReviewDto;
import com.superheroapi.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("superhero/{superheroId}/reviews/create")
@ResponseStatus( HttpStatus.CREATED)
public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto, @PathVariable(value = "superheroId") int heroId){
    return new ResponseEntity<>(reviewService.createReview(reviewDto, heroId), HttpStatus.CREATED );
}

    @GetMapping("superhero/{superheroId}/reviews/{id}")
 public ResponseEntity<ReviewDto> getReviews (@PathVariable(value = "superheroId") int heroId, @PathVariable("id") int id){
        return new ResponseEntity<>(reviewService.getReviewById(id , heroId ), HttpStatus.OK);
    }

    @GetMapping("superhero/{superheroId}/reviews/")
 public ResponseEntity <List<ReviewDto>> getReviewsByHeroId(@PathVariable(value= "superheroId") int id){
          return new ResponseEntity<>( reviewService.getReviewsByHeroId(id), HttpStatus.OK);
    }
    @PutMapping("superhero/{superheroId}/reviews/{id}/delete")
 public ResponseEntity<ReviewDto> updateReview(@PathVariable ReviewDto reviewDto, @PathVariable(value = "superheroId") int heroId  , @PathVariable("id") int id ) {
        return new ResponseEntity<>(reviewService.updateReviews(reviewDto, id, heroId), HttpStatus.OK );
    }
    @DeleteMapping("superhero/{superheroId}/reviews/{id}/delete")
    public ResponseEntity<String> deleteReview(@PathVariable(value = "superheroId") int heroId, @PathVariable("id") int id){
        reviewService.deleteReviews(id, heroId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);

    }
}
