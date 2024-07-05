package com.superheroapi.review.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PowerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public int hero_level;
    public int strength;
    public String type;
    public int speed;
    public int intelligence;

    @OneToOne
    @JoinColumn(name="super_hero_id")
    private SuperHero superHero;

}
