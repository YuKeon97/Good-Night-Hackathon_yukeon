package com.yukeon.yukeon.domain.review.entity;

import com.yukeon.yukeon.domain.restaurant.entity.Restaurant;
import com.yukeon.yukeon.domain.restaurant.entity.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Review(String title, String content, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String content, String title) {
        this.content = content;
        this.title = title;
    }

}
