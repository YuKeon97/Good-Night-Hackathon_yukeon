package com.yukeon.yukeon.domain.restaurant.service;

import com.yukeon.yukeon.domain.restaurant.dto.CreateRestaurantsDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.dto.GetRestaurantListDto;
import com.yukeon.yukeon.domain.restaurant.dto.UpdateRestaurantDto;
import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.restaurant.entity.Type;
import com.yukeon.yukeon.domain.restaurant.mapper.RestaurantMapper;
import com.yukeon.yukeon.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper mapper;
    public void registerRestaurant(CreateRestaurantsDto dto) {
        Restaurant restaurant = Restaurant.builder().name(dto.getName())
                .type(dto.getType())
                .build();
        restaurantRepository.save(restaurant);
    }

    public UpdateRestaurantDto updateRestaurant(UpdateRestaurantDto dto, Long id) {
        Restaurant result = restaurantRepository.findById(id).orElseThrow(null);
        result.update(dto.getName(), dto.getType());
        return mapper.toUpdateDto(result);
    }

    public GetRestaurantListDto getRestaurantList() {
        List<Restaurant> list = restaurantRepository.findAll();
        GetRestaurantListDto dto = new GetRestaurantListDto();
        dto.setRestaurants(list);
        return dto;
    }

    public GetRestaurantListDto getRestaurantListByType(Type type) {
        List<Restaurant> list = restaurantRepository.findAllByType(type);
        GetRestaurantListDto dto = new GetRestaurantListDto();
        dto.setRestaurants(list);
        return dto;
    }

    public GetRestaurantDto getRestaurant(Long id) {
        Restaurant result = restaurantRepository.findById(id).orElseThrow(null);
        return mapper.toGetDto(result);
    }

    public void deleteRestaurant(Long id) {
        Restaurant result = restaurantRepository.findById(id).orElseThrow(null);
        result.softDelete();
    }

    public Page<Restaurant> getWithPage(Integer page, Integer size, String name) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return restaurantRepository.findByName(name, pageRequest);
    }
}
