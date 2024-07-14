package com.superheroapi.review.Mapper;

import com.superheroapi.review.Dto.PowerStatsDto;
import com.superheroapi.review.Dto.SuperHeroDto;
import com.superheroapi.review.models.PowerStats;
import com.superheroapi.review.models.SuperHero;

public class Mapper
{

    public static  SuperHeroDto MappingToSuperHeroDto(SuperHero superHero){
        PowerStatsDto powerStat_Dto = MappingToPowerStatDto(superHero.getPowerStats());
        return SuperHeroDto.builder()
                .Id(superHero.getId())
                .name(superHero.getName())
                .status(superHero.getStatus())
                .alignment(superHero.getAlignment())
                .powerStats(powerStat_Dto)
                .build();


    }
    public static PowerStatsDto MappingToPowerStatDto(PowerStats powerStats){
        return PowerStatsDto.builder()
                .Id(powerStats.getId())
                .type(powerStats.getType())
                .hero_level(powerStats.getHero_level())
                .strength(powerStats.getStrength())
                .intelligence(powerStats.getIntelligence())
                .speed(powerStats.getSpeed())
                .build();

    }
    public static PowerStats MappingToPowerStatEntity(PowerStatsDto powerStatsDto){
        return PowerStats.builder()
                .Id(powerStatsDto.getId())
                .type(powerStatsDto.getType())
                .hero_level(powerStatsDto.getHero_level())
                .strength(powerStatsDto.getStrength())
                .intelligence(powerStatsDto.getIntelligence())
                .speed(powerStatsDto.getSpeed())
                .build();

    }
}
