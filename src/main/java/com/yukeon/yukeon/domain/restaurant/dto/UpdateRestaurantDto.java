package com.yukeon.yukeon.domain.restaurant.dto;

import com.yukeon.yukeon.domain.restaurant.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateRestaurantDto {
    private String name;
    private Type type;

    public void Restaurant(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
