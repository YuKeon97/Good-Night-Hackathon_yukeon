package com.yukeon.yukeon.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetReviewDto {
    private String title;
    private String  content;
    private String  restaurant_name;
}
