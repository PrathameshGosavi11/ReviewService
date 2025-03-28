package com.newgen.reviewservice.service;


import com.newgen.reviewservice.dto.ReviewDTO;
import com.newgen.reviewservice.model.Review;

import java.util.List;

public interface IReviewService
{
    public List<ReviewDTO> getReviewsByProductId(Long productId);

    void addReview(ReviewDTO reviewDTO);

    void deleteReview(Long productId ,Long reviewId);
}
