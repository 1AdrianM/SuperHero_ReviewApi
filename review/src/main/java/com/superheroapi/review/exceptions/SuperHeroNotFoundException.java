package com.superheroapi.review.exceptions;

public class SuperHeroNotFoundException extends RuntimeException {
    //private static final long serialVerisionUID = 1;
    public SuperHeroNotFoundException(String name){
        super(name);
    }
}
