package com.newgen.reviewservice.service;

import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return reviewRepository.findAllByProductId(ProductId);
    }

    @Override
    public void addReview(Review review) {

        reviewRepository.save(review);

    }

    @Override
    public void deleteReview(Long reviewId) {

        reviewRepository.deleteById(reviewId);
    }
}
