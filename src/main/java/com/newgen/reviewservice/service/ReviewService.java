package com.newgen.reviewservice.service;

import com.newgen.reviewservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements  IReviewService {

    @Override
    public List<Review> getReviewsByProductId(Long ProductId) {
        return List.of();
    }

    @Override
    public void addReview(Review review) {

    }

    @Override
    public void deleteReview(Long reviewId) {

    }
}
