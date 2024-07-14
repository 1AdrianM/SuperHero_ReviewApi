package com.superheroapi.review.service.Implementation;

import com.superheroapi.review.Dto.PowerStatsDto;
import com.superheroapi.review.Dto.SuperHeroDto;
import com.superheroapi.review.Dto.SuperHeroResponse;
import com.superheroapi.review.Mapper.SuperHeroMapper;
import com.superheroapi.review.exceptions.SuperHeroNotFoundException;
import com.superheroapi.review.models.PowerStats;
import com.superheroapi.review.models.SuperHero;
import com.superheroapi.review.repository.SuperHeroRepository;
import com.superheroapi.review.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.superheroapi.review.Mapper.SuperHeroMapper.*;

@Service
public class SuperHeroImplementation implements SuperHeroService {
@Autowired
    private final SuperHeroRepository superHeroRepository;

    public SuperHeroImplementation(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }
    @Override
    public SuperHeroDto createSuperHero(SuperHeroDto superHeroDto) {
        PowerStats powerStats = new PowerStats();
        powerStats.setId(superHeroDto.getPowerStats().getId());
        powerStats.setHero_level(superHeroDto.getPowerStats().getHero_level());
        powerStats.setIntelligence(superHeroDto.getPowerStats().getIntelligence());
        powerStats.setStrength(superHeroDto.getPowerStats().getStrength());
        powerStats.setType(superHeroDto.getPowerStats().getType());

    //
        SuperHero hero  = new SuperHero();
      hero.setId(superHeroDto.getId());
    hero.setName(superHeroDto.getName());
    hero.setStatus(superHeroDto.getStatus());
    hero.setAlignment(superHeroDto.getAlignment());
    hero.setPowerStats(powerStats);
   //
        powerStats.setSuperHero(hero);// Estableciendo relacion
    SuperHero Hero = superHeroRepository.save(hero);
   //
    SuperHeroDto heroResponse = new SuperHeroDto();

    heroResponse.setId(Hero.getId());
    heroResponse.setName(Hero.getName());
    heroResponse.setStatus(Hero.getStatus());
    heroResponse.setAlignment(Hero.getAlignment());
    PowerStatsDto PS = MappingToPowerStatDto(Hero.getPowerStats());
 heroResponse.setPowerStats(PS);
    //
    return heroResponse;

    } @Override
    public SuperHeroResponse getAllSuperHero(int PageNo, int PageSize) {
        Pageable pageable = PageRequest.of(PageNo, PageSize);
        Page <SuperHero> heroList = superHeroRepository.findAll( pageable);
        List<SuperHero>  list_Pokemon = heroList.getContent();
        List<SuperHeroDto> content = list_Pokemon.stream().map(SuperHeroMapper::MappingToSuperHeroDto).collect(Collectors.toList());

        SuperHeroResponse superHeroResponse  = new SuperHeroResponse();

        superHeroResponse.setPageNo(heroList.getNumber());
        superHeroResponse.setPageSize(heroList.getSize());
        superHeroResponse.setTotalPages(heroList.getTotalPages());
         superHeroResponse.setTotalElements(heroList.getTotalElements());
         superHeroResponse.setLast(heroList.isLast());
         superHeroResponse.setContent(content);

         return superHeroResponse;
    }

    @Override
    public SuperHeroDto getSuperHeroId(int id) {
        SuperHero superHero = superHeroRepository.findById(id).orElseThrow(()-> new SuperHeroNotFoundException("Super Hero not Found by this Id"));
        return MappingToSuperHeroDto(superHero);
    }

    @Override
    public SuperHeroDto updateSuperHero(SuperHeroDto superHeroDto, int id) {
         SuperHero superHero =  superHeroRepository.findById(id).orElseThrow(()-> new SuperHeroNotFoundException("Cant Update this SuperHero"));

         superHero.setAlignment(superHeroDto.getAlignment());
       superHero.setName(superHeroDto.getName());
       PowerStats PS =  MappingToPowerStatEntity(superHeroDto.getPowerStats());
      superHero.setPowerStats(PS);
       superHero.setStatus(superHeroDto.getStatus());

       SuperHero updatedHero = superHeroRepository.save(superHero);
       return MappingToSuperHeroDto(updatedHero);
    }

    @Override
    public void deleteSuperHeroId(int id) {
        SuperHero superHero = superHeroRepository.findById(id).orElseThrow(()-> new SuperHeroNotFoundException("Super Hero could not be deleted"));
        superHeroRepository.delete(superHero);

    }




}
