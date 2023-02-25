package com.yukeon.yukeon.domain.review.controller;

import com.yukeon.yukeon.domain.restaurant.dto.CreateRestaurantsDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantListDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantListWithReviewDto;
import com.yukeon.yukeon.domain.restaurant.dto.UpdateRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.entity.Type;
import com.yukeon.yukeon.domain.review.dto.CreateReviewDto;
import com.yukeon.yukeon.domain.review.dto.GetReviewDto;
import com.yukeon.yukeon.domain.review.dto.GetReviewListDto;
import com.yukeon.yukeon.domain.review.dto.UpdateReviewDto;
import com.yukeon.yukeon.domain.review.entity.OrderByType;
import com.yukeon.yukeon.domain.review.repository.ReviewRepository;
import com.yukeon.yukeon.domain.review.service.ReviewService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 리뷰 목록 조회 [GET] /api/v1/reviews/list
 * 리뷰 조회    [GET] /api/v1/reviews/{id}
 * 리뷰 수정    [POST] /api/v1/reviews/{id}
 * 리뷰 작성    [POST] /api/v1/reviews/new
 * 리뷰 삭제    [DELETE] /api/v1/reviews/{id}
 */
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    // 리뷰 목록 조회(시간순)
    @GetMapping("/list/order-by-asc")
    public List<GetReviewListDto> readAllOrderByTimeAsc() {
        return reviewService.getReviewListOrderByTimeAsc();
    }

    // 리뷰 목록 조회(역순)
    @GetMapping("/list/order-by-decs")
    public List<GetReviewListDto> readAllOrderByTimeDecs() {
        return reviewService.getReviewListOrderByTimeDecs();
    }

    // 리뷰 조회
    @GetMapping("/{id}")
    public GetReviewDto readReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    // 리뷰 목록 조회
    @GetMapping("/list")
    public List<GetRestaurantListWithReviewDto> readAll() {
        return reviewService.getReviewList();
    }


    // 리뷰 수정
    @PostMapping("/{id}}")
    public UpdateReviewDto update(@RequestBody UpdateReviewDto dto,
                                      @PathVariable Long id) {
        return reviewService.updateReview(dto, id);
    }

    // 리뷰 작성
    @PostMapping("/new")
    public void create(@RequestBody CreateReviewDto dto) {
        reviewService.registerReview(dto);
    }

    // 리뷰 삭제
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    // 리뷰 목록 조회(리뷰 제목으로 검색)
    @GetMapping("/list/by-title")
    public List<GetReviewListDto> readReviewByTitle(String title) {
        return reviewService.getReviewListByTitle(title);
    }

    // 리뷰 목록 조회(리뷰 내용으로 검색)
    @GetMapping("/list/by-content")
    public List<GetReviewListDto> readReviewByContent(String content) {
        return reviewService.getReviewListByContent(content);
    }

}
