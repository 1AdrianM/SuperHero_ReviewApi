package com.superheroapi.review.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
public int id;
public String Title;
public String content;
public int stars;
@ManyToOne(fetch =FetchType.LAZY)
@JoinColumn(name = "superhero_id")
private SuperHero superHero;
}
