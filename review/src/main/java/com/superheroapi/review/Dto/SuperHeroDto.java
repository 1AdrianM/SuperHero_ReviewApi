package com.superheroapi.review.Dto;

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
    public int powerStatsId;
    public String alignment;
    public String status;
}
