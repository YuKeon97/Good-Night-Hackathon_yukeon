package com.yukeon.yukeon.domain.review.repository;

import com.yukeon.yukeon.domain.restaurant.entity.Type;
import com.yukeon.yukeon.domain.review.entity.OrderByType;
import com.yukeon.yukeon.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findFirstById(Long id);

    List<Review> findAllByOrderByCreatedAtAsc();

    List<Review> findAllByOrderByCreatedAtDesc();

    List<Review> findReviewsByContentLike(String content);
    List<Review> findReviewsByTitleLike(String title);

}
