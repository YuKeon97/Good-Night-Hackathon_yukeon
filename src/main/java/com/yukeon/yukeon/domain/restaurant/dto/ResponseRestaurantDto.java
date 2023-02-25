package com.yukeon.yukeon.domain.restaurant.dto;

import com.yukeon.yukeon.domain.restaurant.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public interface ResponseRestaurantDto {
    Long getRestaurantId();

    String getName();

    Type getType();

}
