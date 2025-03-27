package com.newgen.reviewservice.service;


import com.newgen.reviewservice.model.Review;

import java.util.List;

public interface IReviewService
{
    public List<Review> getReviewsByProductId(Long productId);

    void addReview(Review review);

    void deleteReview(Long productId ,Long reviewId);
}
