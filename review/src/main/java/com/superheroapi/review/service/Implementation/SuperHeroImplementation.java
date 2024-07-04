package com.superheroapi.review.service.Implementation;

import com.superheroapi.review.Dto.SuperHeroDto;
import com.superheroapi.review.Dto.SuperHeroResponse;
import com.superheroapi.review.exceptions.SuperHeroNotFoundException;
import com.superheroapi.review.models.SuperHero;
import com.superheroapi.review.repository.SuperHeroRepository;
import com.superheroapi.review.service.SuperHeroService;
import org.apache.catalina.connector.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SuperHeroImplementation implements SuperHeroService {

    private final SuperHeroRepository superHeroRepository;

    public SuperHeroImplementation(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }
    @Override
    public SuperHeroDto createSuperHero(SuperHeroDto superHeroDto) {
      SuperHero hero =  new SuperHero();
    //
      hero.setId(superHeroDto.getId());
    hero.setName(superHeroDto.getName());
    hero.setStatus(superHeroDto.getStatus());
    hero.setAlignment(superHeroDto.getAlignment());
    hero.setPowerStatsId(superHeroDto.getPowerStatsId());
   //
    SuperHero Hero = superHeroRepository.save(hero);
   //
    SuperHeroDto heroResponse = new SuperHeroDto();
    Hero.setId(heroResponse.getId());
    Hero.setName(heroResponse.getName());
    Hero.setStatus(heroResponse.getStatus());
    Hero.setAlignment(heroResponse.getAlignment());
    Hero.setPowerStatsId(heroResponse.getPowerStatsId());
//
    return heroResponse;

    } @Override
    public SuperHeroResponse getAllSuperHero(int PageNo, int PageSize) {
        Pageable pageable = (Pageable) PageRequest.of(PageNo, PageSize);
        Page <SuperHero> heroList = superHeroRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<SuperHero>  list_Pokemon = heroList.getContent();
        List<SuperHeroDto> content = list_Pokemon.stream().map(hero-> MappingToDto(hero)).collect(Collectors.toList());

        SuperHeroResponse superHeroResponse  = new SuperHeroResponse();

        superHeroResponse.setPageNo(heroList.getNumber());
        superHeroResponse.setPageSize(heroList.getSize());
        superHeroResponse.setTotalPages(heroList.getTotalPages());
         superHeroResponse.setTotalElements(heroList.getTotalElements());
         superHeroResponse.setContent(content);

         return superHeroResponse;
    }

    @Override
    public SuperHeroDto getSuperHeroId(int id) {
        SuperHero superHero = superHeroRepository.findById(id).orElseThrow(()-> new SuperHeroNotFoundException("Super Hero not Found by this Id"));
        return MappingToDto(superHero);
    }

    @Override
    public SuperHeroDto updateSuperHero(SuperHeroDto superHeroDto, int id) {
         SuperHero superHero =  superHeroRepository.findById(id).orElseThrow(()-> new SuperHeroNotFoundException("Cant Update this SuperHero"));
       superHero.setId(superHeroDto.getId());
       superHero.setAlignment(superHeroDto.getAlignment());
       superHero.setName(superHeroDto.getName());
       superHero.setPowerStatsId(superHeroDto.getPowerStatsId());
       superHero.setStatus(superHeroDto.getStatus());

       SuperHero updatedHero = superHeroRepository.save(superHero);
       return MappingToDto(updatedHero);
    }

    @Override
    public void deleteSuperHeroId(int id) {
        SuperHero superHero = superHeroRepository.findById(id).orElseThrow(()-> new SuperHeroNotFoundException("Super Hero could not be deleted"));
        superHeroRepository.delete(superHero);

    }


    private SuperHeroDto MappingToDto(SuperHero superHero){
SuperHeroDto heroDto =  new SuperHeroDto();
heroDto.setId(superHero.getId());
heroDto.setName(superHero.getName());
heroDto.setStatus(superHero.getStatus());
heroDto.setAlignment(superHero.getAlignment());
heroDto.setPowerStatsId(superHero.getPowerStatsId());
    return heroDto;

    }
}
