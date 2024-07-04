package com.superheroapi.review.exceptions;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(String name){
        super(name);
    }
}
