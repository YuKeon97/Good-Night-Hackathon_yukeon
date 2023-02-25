package com.yukeon.yukeon.domain.restaurant.dto;

import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.restaurant.entity.Type;
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
public class GetRestaurantDto {
    private String name;
    private Type type;
    private LocalDateTime createdAt;
}
