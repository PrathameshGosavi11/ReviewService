package com.newgen.reviewservice.service;

import com.newgen.reviewservice.dto.ReviewDTO;
import com.newgen.reviewservice.mapper.ReviewMapper;
import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.model.ReviewDetails;
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
    private final ReviewMapper reviewMapper;
    //depency injection with construtor
    @Autowired
    public  ReviewService(ReviewRepository reviewRepository,ReviewMapper reviewMapper)
    {
        this.reviewRepository=reviewRepository;
        this.reviewMapper=reviewMapper;
    }

    @Override
    public ReviewDetails getReviewsByProductId(Long ProductId) {

        log.info("request come on service ");
         List<ReviewDTO> reviews= reviewRepository.findAllByProductId(ProductId)
                 .stream()
                .map(reviewMapper:: toDTO)
                .toList();

         ReviewDetails reviewDetails=new ReviewDetails();
         reviewDetails.setReviews(reviews);
         return reviewDetails;



    }

//    private ReviewDTO MapToReviewDTO(Review review) {
//
//        log.info("setting start");
//        ReviewDTO reviewDTO=new ReviewDTO();
//        reviewDTO.setReviewId(review.getReviewId());
//        reviewDTO.setUserId(review.getUserId());
//        reviewDTO.setProductId(review.getProductId());
//        reviewDTO.setRatings(review.getRatings());
//        reviewDTO.setTitle(review.getTitle());
//        reviewDTO.setDescription(review.getDescription());
//        reviewDTO.setCreatedAt(review.getCreatedAt());
//        log.info("setting end ");
//        return reviewDTO;
//    }

    @Override
    public void addReview(ReviewDTO reviewDTO) {
        Review  review= reviewMapper.toReview(reviewDTO);
        review.setCreatedBy("System");
        review.setUpdatedBy("System");
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        reviewRepository.save(review);
    }

//    private Review maptoReview(ReviewDTO reviewDTO) {
//
//        Review review=new Review();
//        review.setProductId(reviewDTO.getProductId());
//        review.setUserId(reviewDTO.getUserId());
//        review.setRatings(reviewDTO.getRatings());
//        review.setTitle(reviewDTO.getTitle());
//        review.setDescription(reviewDTO.getDescription());
//       return review ;
//
//    }

    @Override
    @Transactional
    public void deleteReview(Long productId ,Long reviewId) {

        log.info("Request come on service");
        reviewRepository.deleteReviewByProductIdAndReviewId(productId ,reviewId);
    }
}
