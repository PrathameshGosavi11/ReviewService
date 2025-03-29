package com.newgen.reviewservice.mapper;

import com.newgen.reviewservice.dto.ReviewDTO;
import com.newgen.reviewservice.model.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReviewMapper
{
    public ReviewDTO toDTO(Review review) //entity to DTO
    {
        log.info("setting start");
        ReviewDTO reviewDTO=new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setUserId(review.getUserId());
        reviewDTO.setProductId(review.getProductId());
        reviewDTO.setRatings(review.getRatings());
        reviewDTO.setTitle(review.getTitle());
        reviewDTO.setDescription(review.getDescription());
        reviewDTO.setCreatedAt(review.getCreatedAt());
        log.info("setting end ");
        return  reviewDTO;
    }

    public Review toReview(ReviewDTO reviewDTO) //DTO to entity
    {
        Review review=new Review();
        review.setProductId(reviewDTO.getProductId());
        review.setUserId(reviewDTO.getUserId());
        review.setRatings(reviewDTO.getRatings());
        review.setTitle(reviewDTO.getTitle());
        review.setDescription(reviewDTO.getDescription());
        return review ;

    }
}
