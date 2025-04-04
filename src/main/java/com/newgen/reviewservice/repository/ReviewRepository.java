package com.newgen.reviewservice.repository;

import com.newgen.reviewservice.dto.ReviewDTO;
import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.model.ReviewDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>  {

    List<Review> findAllByProductId(Long productId);

    void deleteReviewByProductIdAndReviewId(Long productId, Long reviewId);
}
