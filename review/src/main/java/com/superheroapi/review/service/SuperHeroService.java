package com.superheroapi.review.service;

import com.superheroapi.review.Dto.SuperHeroDto;
import com.superheroapi.review.Dto.SuperHeroResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SuperHeroService {
SuperHeroDto createSuperHero(SuperHeroDto superHeroDto);
SuperHeroResponse getAllSuperHero(int PageNo, int PageSize);
    SuperHeroDto getSuperHeroId(int id);
    SuperHeroDto updateSuperHero(SuperHeroDto superHeroDto, int id);
    void deleteSuperHeroId(int id);
}
