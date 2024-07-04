package com.superheroapi.review.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class GlobalExceptions {
    @ExceptionHandler(SuperHeroNotFoundException.class)
   public ResponseEntity<ErrorModel> handleHeroException(SuperHeroNotFoundException ex, WebRequest request){
        ErrorModel errorObj = new ErrorModel();

        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());

        return new ResponseEntity<ErrorModel>(errorObj, HttpStatus.NOT_FOUND);
    }
}
