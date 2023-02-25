package com.yukeon.yukeon.domain.restaurant.controller;

import com.yukeon.yukeon.domain.restaurant.dto.CreateRestaurantsDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantListDto;
import com.yukeon.yukeon.domain.restaurant.dto.UpdateRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.restaurant.entity.Type;
import com.yukeon.yukeon.domain.restaurant.service.RestaurantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 레스토랑 등록 [POST] /api/v1/restaurants/new
 *
 * 레스토랑 수정 [POST] /api/v1/restaurants/{id}
 *
 * 레스토랑 목록 조회   [GET] /api/v1/restaurant/list/all
 *
 * 레스토랑 타입으로 목록 조회   [GET] /api/v1/restaurant/list?type={type}
 *
 * 레스토랑 조회  [GET] /api/v1/restaurants/{id}
 *
 * 레스토랑 삭제  [DELETE] /api/v1/restaurants/{id}
 */
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    // 레스토랑 등록
    @PostMapping("/new")
    public void create(@RequestBody CreateRestaurantsDto dto) {
        restaurantService.registerRestaurant(dto);
    }

    // 레스토랑 수정
    @PostMapping("/{id}}")
    public UpdateRestaurantDto update(@RequestBody UpdateRestaurantDto dto,
                                      @PathVariable Long id) {
        return restaurantService.updateRestaurant(dto, id);
    }

    // 레스토랑 목록 조회
    @GetMapping("/list/all")
    public GetRestaurantListDto readAll() {
        return restaurantService.getRestaurantList();
    }

    // 레스토랑 타입으로 목록 조회
    @GetMapping("/list")
    public GetRestaurantListDto readAllByType(@RequestParam Type type) {
        return restaurantService.getRestaurantListByType(type);
    }

    // 레스토랑 조회
    @GetMapping("/{id}")
    public GetRestaurantDto readRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }

    // 레스토랑 삭제
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/page")
    public Page<Restaurant> getRestaurantsWithPage(@RequestParam Integer page, @RequestParam Integer size,
                                                   @RequestParam String name) {
        return restaurantService.getWithPage(page, size, name);
    }
}
