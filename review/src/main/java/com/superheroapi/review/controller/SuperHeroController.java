package com.superheroapi.review.controller;

import com.superheroapi.review.Dto.SuperHeroDto;
import com.superheroapi.review.Dto.SuperHeroResponse;
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

    @PostMapping("superhero/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuperHeroDto> createSuperHero(@RequestBody SuperHeroDto  superHeroDto){
     return new ResponseEntity<>(superHeroService.createSuperHero(superHeroDto), HttpStatus.CREATED);

    }

    @GetMapping("/superheroes")
    public ResponseEntity<SuperHeroResponse> getSuperHeroes(
            @RequestParam(value = "PageNo", defaultValue = "0",  required = false) int PageNo,
            @RequestParam(value = "PageSize", defaultValue = "10",  required = false) int PageSize
    ){
      SuperHeroResponse response = superHeroService.getAllSuperHero(PageNo, PageSize);
return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("superhero/{id}")
    public ResponseEntity<SuperHeroDto> getSuperHeroById(@PathVariable  int id){
 return new ResponseEntity<>(superHeroService.getSuperHeroId(id), HttpStatus.OK);
    }


    @PutMapping("superhero/{id}/update")
    public ResponseEntity<SuperHeroDto>  updateSuperHero(@RequestBody SuperHeroDto heroDto, @PathVariable int id){
 return new ResponseEntity<>(superHeroService.updateSuperHero(heroDto,id ), HttpStatus.OK);
    }

    @DeleteMapping("superhero/{id}/delete")
    public ResponseEntity<String>  deleteSuperHero(@PathVariable int id){
        superHeroService.deleteSuperHeroId(id);
        return new ResponseEntity<>("Hero deleted",HttpStatus.OK);
    }

}
