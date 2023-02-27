package com.yukeon.yukeon.domain.restaurant.dto;

import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.review.dto.GetReviewDto;
import com.yukeon.yukeon.domain.review.dto.GetReviewListDto;
import com.yukeon.yukeon.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetRestaurantListWithReviewDto {
    private String  restaurant_name;
    private List<GetReviewListDto> reviews;
    public GetRestaurantListWithReviewDto() {
    }
}
