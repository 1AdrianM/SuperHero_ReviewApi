package com.superheroapi.review.repository;

import com.superheroapi.review.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findHerobyId(int heroId);
}
