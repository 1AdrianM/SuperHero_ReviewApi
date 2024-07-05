package com.superheroapi.review.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class PowerStatsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public int hero_level;
    public int strength;
    public String type;
    public int speed;
    public int intelligence;
}
