package com.newgen.reviewservice.service;

import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.repository.ReviewRepository;
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
    public List<Review> getReviewsByProductId(Long ProductId) {

        log.info("request come on service ");
        return reviewRepository.findAllByProductId(ProductId);
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
    public void deleteReview(Long productId ,Long reviewId) {

        reviewRepository.deleteReviewByProductIdAndReviewId(productId ,reviewId);
    }
}
