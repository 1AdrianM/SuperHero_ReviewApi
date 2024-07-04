package com.superheroapi.review.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {
    private Integer StatusCode;
    private String  Message;
    private Date Timestamp;

}
