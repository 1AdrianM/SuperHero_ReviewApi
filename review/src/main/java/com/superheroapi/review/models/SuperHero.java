package com.superheroapi.review.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
public String name;
public String weakness;
public String alignment;
public String status;
@OneToMany(mappedBy ="superHero" , cascade = CascadeType.ALL, orphanRemoval = true)
private List<Review> reviewList = new ArrayList<Review>();
@OneToOne(mappedBy = "superHero", cascade =CascadeType.ALL)
    private PowerStats powerStats;


}
