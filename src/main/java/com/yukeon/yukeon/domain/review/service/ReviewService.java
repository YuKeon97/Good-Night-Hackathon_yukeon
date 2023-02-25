package com.yukeon.yukeon.domain.review.service;

import com.yukeon.yukeon.domain.restaurant.dto.CreateRestaurantsDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantListWithReviewDto;
import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.restaurant.mapper.RestaurantMapper;
import com.yukeon.yukeon.domain.restaurant.repository.RestaurantRepository;
import com.yukeon.yukeon.domain.review.dto.*;
import com.yukeon.yukeon.domain.review.entity.OrderByType;
import com.yukeon.yukeon.domain.review.entity.Review;
import com.yukeon.yukeon.domain.review.mapper.ReviewMapper;
import com.yukeon.yukeon.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper mapper;
    private final RestaurantMapper restaurantMapper;

    private final RestaurantRepository restaurantRepository;

    public void registerReview(CreateReviewDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurant_id()).orElseThrow(null);
        Review review = mapper.toEntity(dto, restaurant);
        reviewRepository.save(review);
    }

    public GetReviewDto getReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        return mapper.toGetReviewDto(review);
    }

    public UpdateReviewDto updateReview(UpdateReviewDto dto, Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        review.update(dto.getContent(), dto.getTitle());
        return mapper.toUpdateDto(review);

    }

    public void deleteReview(Long id) {
        Review review = reviewRepository.findFirstById(id);
        reviewRepository.delete(review);
    }

    public List<GetRestaurantListWithReviewDto> getReviewList() {
        List<Review> reviews = reviewRepository.findAll();
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurantMapper.toDto(restaurants, mapper.toGGetReviewListDto(reviews));
    }

    public List<GetReviewListDto> getReviewListOrderByTimeAsc() {
        List<Review> list = reviewRepository.findAllByOrderByCreatedAtAsc();
        return mapper.toGGetReviewListDto(list);


    }

    public List<GetReviewListDto> getReviewListOrderByTimeDecs() {
        List<Review> list = reviewRepository.findAllByOrderByCreatedAtDesc();
        return mapper.toGGetReviewListDto(list);
    }

    public List<GetReviewListDto> getReviewListByTitle(String title) {
        List<Review> list = reviewRepository.findReviewsByTitleLike(title);
        return mapper.toGGetReviewListDto(list);
    }

    public List<GetReviewListDto> getReviewListByContent(String content) {
        List<Review> list = reviewRepository.findReviewsByContentLike(content);
        return mapper.toGGetReviewListDto(list);
    }
}
