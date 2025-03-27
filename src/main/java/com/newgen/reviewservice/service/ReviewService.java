package com.newgen.reviewservice.service;

import com.newgen.reviewservice.dto.ReviewDTO;
import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class ReviewService implements  IReviewService {

    private  final ReviewRepository reviewRepository;

    //depency injection with construtor
    @Autowired
    public  ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository=reviewRepository;
    }

    @Override
    public List<ReviewDTO> getReviewsByProductId(Long ProductId) {

        log.info("request come on service ");
        //ip- List<Review>
        //op -List<reviewDTO>

        final List<ReviewDTO> reviews= reviewRepository.findAllByProductId(ProductId);

       List<ReviewDTO> reviewDTOS= reviews.stream().map(review -> MapToReviewDTO(review))
                .toList();
        return  reviewDTOS;
    }

    private ReviewDTO MapToReviewDTO(ReviewDTO review) {

        ReviewDTO reviewDTO=new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setUserId(reviewDTO.getUserId());
        reviewDTO.setProductId(reviewDTO.getProductId());
        reviewDTO.setRatings(reviewDTO.getRatings());
        reviewDTO.setTitle(reviewDTO.getTitle());
        reviewDTO.setDescription(reviewDTO.getDescription());
        reviewDTO.setCreatedAt(review.getCreatedAt());
        return reviewDTO;
    }

    @Override
    public void addReview(Review review) {

        review.setCreatedBy("System");
        review.setUpdatedBy("System");
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void deleteReview(Long productId ,Long reviewId) {

        log.info("Request come on service");
        reviewRepository.deleteReviewByProductIdAndReviewId(productId ,reviewId);
    }
}
