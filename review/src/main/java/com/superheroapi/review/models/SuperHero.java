package com.superheroapi.review.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
public String name;
public int powerStatsId;
public String alignment;
public String status;
}
