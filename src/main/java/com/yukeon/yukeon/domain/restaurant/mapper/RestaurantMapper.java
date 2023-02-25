package com.yukeon.yukeon.domain.restaurant.mapper;

import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantListWithReviewDto;
import com.yukeon.yukeon.domain.restaurant.dto.UpdateRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.review.dto.GetReviewListDto;
import com.yukeon.yukeon.domain.review.entity.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantMapper {

    public UpdateRestaurantDto toUpdateDto(Restaurant restaurant) {
        return UpdateRestaurantDto.builder().build().builder().name(restaurant.getName())
                .type(restaurant.getType()).build();
    }

    public GetRestaurantDto toGetDto(Restaurant restaurant) {
        return GetRestaurantDto.builder().build().builder().name(restaurant.getName())
                .type(restaurant.getType()).createdAt(restaurant.getCreatedAt()).build();
    }

    public List<GetRestaurantListWithReviewDto> toDto(List<Restaurant> restaurants, List<GetReviewListDto> reviews) {

        List<GetRestaurantListWithReviewDto> list = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            GetRestaurantListWithReviewDto dto = GetRestaurantListWithReviewDto.builder().build().builder()
                    .reviews(reviews).restaurant_name(restaurant.getName()).build();
            list.add(dto);
        }
        return list;

    }

}
