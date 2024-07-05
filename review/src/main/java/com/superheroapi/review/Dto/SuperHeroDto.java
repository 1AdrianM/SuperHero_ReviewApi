package com.superheroapi.review.Dto;

import com.superheroapi.review.models.PowerStats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroDto {
    public int Id;
    public String name;
    public String alignment;
    public String status;
    private  PowerStatsDto powerStatsDto;
}
