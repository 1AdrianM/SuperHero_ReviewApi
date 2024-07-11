package com.superheroapi.review.controller;

import com.superheroapi.review.Dto.ReviewDto;
import com.superheroapi.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("hero/{heroId}/reviews/create")
@ResponseStatus( HttpStatus.CREATED)
public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto rdto, @PathVariable("heroId") int heroId){
    return new ResponseEntity<>(reviewService.createReview(rdto, heroId), HttpStatus.CREATED );
}

    @GetMapping("hero/{heroId}/reviews/{id}")
 public ResponseEntity<ReviewDto> getReviews (@PathVariable("heroId") int heroId, @PathVariable("id") int id){
        return new ResponseEntity<ReviewDto>(reviewService.getReviewById(id , heroId ), HttpStatus.OK);
    }

   // @GetMapping("")

    @PutMapping("hero/{heroId}/reviews/{id}/delete")
 public ResponseEntity<ReviewDto> updateReview(@PathVariable ReviewDto reviewDto, @PathVariable("heroId") int heroId  , @PathVariable("id") int id ) {
        return new ResponseEntity<>(reviewService.updateReviews(reviewDto, id, heroId), HttpStatus.OK );
    }
    @DeleteMapping("hero/{heroId}/reviews/{id}/delete")
    public ResponseEntity<String> deleteReview(@PathVariable("heroId") int heroId, @PathVariable("id") int id){
        reviewService.deleteReviews(id, heroId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);

    }
}
