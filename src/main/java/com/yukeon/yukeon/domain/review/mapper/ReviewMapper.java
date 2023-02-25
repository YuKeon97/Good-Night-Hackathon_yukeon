package com.yukeon.yukeon.domain.review.mapper;

import com.yukeon.yukeon.domain.restaurant.dto.UpdateRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.review.dto.*;
import com.yukeon.yukeon.domain.review.entity.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewMapper {
    public Review toEntity(CreateReviewDto dto, Restaurant restaurant) {
        Review review = Review.builder().title(dto.getTitle()).content(dto.getContent())
                .restaurant(restaurant).build();
        return review;
    }


    public List<GetReviewListDto> toGGetReviewListDto(List<Review> reviews) {
        List<GetReviewListDto> list = new ArrayList();
        for (Review review : reviews) {
            GetReviewListDto dto = GetReviewListDto.builder().build().builder()
                    .content(review.getContent()).title(review.getTitle()).time(review.getCreatedAt()).build();
            list.add(dto);
        }
        return list;
    }

    public GetReviewDto toGetReviewDto(Review review) {
        return GetReviewDto.builder().build().builder().restaurant_name(review.getRestaurant().getName())
                .title(review.getTitle()).content(review.getContent()).build();
    }

    public UpdateReviewDto toUpdateDto(Review review) {
        return UpdateReviewDto.builder().build().builder().content(review.getContent())
                .title(review.getTitle()).build();
    }
}
