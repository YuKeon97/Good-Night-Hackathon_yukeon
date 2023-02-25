package com.yukeon.yukeon.domain.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yukeon.yukeon.domain.review.entity.Review;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @CreatedDate
    private LocalDateTime createdAt;

    private Boolean isDeleted;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public Restaurant(String name, Type type) {
        this.name = name;
        this.type = type;
        this.isDeleted = false;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public void softDelete() {this.isDeleted = true;}

}
