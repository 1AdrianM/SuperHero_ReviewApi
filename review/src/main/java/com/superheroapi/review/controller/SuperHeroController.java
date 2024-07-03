package com.superheroapi.review.controller;

import com.superheroapi.review.Dto.SuperHeroDto;
import com.superheroapi.review.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SuperHeroController {
    private final SuperHeroService superHeroService;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @PostMapping("hero/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuperHeroDto> createSuperHero(@RequestBody SuperHeroDto  superHeroDto){
     return new ResponseEntity<>(superHeroService.createSuperHero(superHeroDto), HttpStatus.CREATED);

    }

    @GetMapping("/heroes")
    public ResponseEntity<List<SuperHeroDto>> getSuperHeroes(){
return new ResponseEntity<>( superHeroService.getAllSuperHero(), HttpStatus.OK);
    }


    @GetMapping("hero/{id}")
    public ResponseEntity<SuperHeroDto> getSuperHerobyId(@PathVariable  int id){
 return new ResponseEntity<>(superHeroService.getSuperHeroId(id), HttpStatus.OK);
    }


    @PutMapping("hero/{id}/update")
    public ResponseEntity<SuperHeroDto>  updateSuperHero(@RequestBody SuperHeroDto heroDto, @PathVariable int id){
 return new ResponseEntity<>(superHeroService.updateSuperHero(heroDto,id ), HttpStatus.OK);
    }

    @DeleteMapping("hero/{id}/delete")
    public ResponseEntity<String>  deleteSuperHero(@PathVariable int id){
        superHeroService.deleteSuperHeroId(id);
        return new ResponseEntity<>("Hero deleted",HttpStatus.OK);
    }

}
