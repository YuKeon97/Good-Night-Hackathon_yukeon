package com.yukeon.yukeon.domain.review.dto;

import com.yukeon.yukeon.domain.restaurant.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateReviewDto {
    private String title;
    private String  content;
    private Long restaurant_id;
}
