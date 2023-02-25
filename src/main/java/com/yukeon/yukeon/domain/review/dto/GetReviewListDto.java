package com.yukeon.yukeon.domain.review.dto;

import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetReviewListDto {

    private String title;
    private String content;
    private LocalDateTime time;

    public GetReviewListDto() {}
}
