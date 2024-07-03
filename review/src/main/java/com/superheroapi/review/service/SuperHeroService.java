package com.superheroapi.review.service;

import com.superheroapi.review.Dto.SuperHeroDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SuperHeroService {
SuperHeroDto createSuperHero(SuperHeroDto superHeroDto);
List<SuperHeroDto> getAllSuperHero();
    SuperHeroDto getSuperHeroId(int id);
    SuperHeroDto updateSuperHero(SuperHeroDto superHeroDto, int id);
    void deleteSuperHeroId(int id);
}
