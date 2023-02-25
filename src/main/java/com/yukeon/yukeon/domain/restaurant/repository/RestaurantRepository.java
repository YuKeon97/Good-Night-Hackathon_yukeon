package com.yukeon.yukeon.domain.restaurant.repository;

import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.restaurant.entity.Type;
import com.yukeon.yukeon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByTypeAndIsDeletedFalse(Type type);

    Page<Restaurant> findByName(String name, Pageable pageable);

    List<Restaurant> findAllByIsDeletedFalse();

}
