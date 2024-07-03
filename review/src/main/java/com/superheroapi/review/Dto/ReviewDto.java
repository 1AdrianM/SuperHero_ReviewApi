package com.superheroapi.review.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDto {
    public int Id;
    public String Title;
    public String content;
    public int start;
}
