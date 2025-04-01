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
import java.util.Map;
import java.util.stream.Collectors;

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
         calculateRatingDetails(reviews,reviewDetails);
         reviewDetails.setReviews(reviews);
         return reviewDetails;
    }
    private void calculateRatingDetails(List<ReviewDTO> reviews, ReviewDetails reviewDetails) {

//
            final Map<Integer,Long> ratingMap=
            reviews.stream().collect(Collectors.groupingBy(ReviewDTO::getRatings, Collectors.counting()));

        int oneStarRatings=ratingMap.getOrDefault((int)1 ,0L).intValue();
        int twoStarRatings=ratingMap.getOrDefault((int)2 ,0L).intValue();
        int threeStarRatings=ratingMap.getOrDefault((int)3 ,0L).intValue();
        int fourStarRatings=ratingMap.getOrDefault((int)4 ,0L).intValue();
        int fiveStarRatings=ratingMap.getOrDefault((int)5 ,0L).intValue();

        int totalRatings=(1 * oneStarRatings+ 2 * twoStarRatings+ 3 * threeStarRatings + 4* fourStarRatings+ 5* fiveStarRatings);

        double avgRating=(double) totalRatings/reviews.size();


//        int oneStarRatings = 0;
//        int twoStarRatings = 0;
//        int threeStarRatings = 0;
//        int fourStarRatings = 0;
//        int fiveStarRatings = 0;
//        int totalRatings = 0;
//
//        for (ReviewDTO reviewDTO : reviews) {
//            int ratings = reviewDTO.getRatings();
//            totalRatings++;
//
//            switch (ratings) {
//                case 1 -> oneStarRatings++;
//                case 2 -> twoStarRatings++;
//                case 3 -> threeStarRatings++;
//                case 4 -> fourStarRatings++;
//                case 5 -> fiveStarRatings++;
//            }
//
//        }

        reviewDetails.setTotalOneStarRatings(oneStarRatings);
        reviewDetails.setTotalTwoStarRatings(twoStarRatings);
        reviewDetails.setTotalThreeStarRatings(threeStarRatings);
        reviewDetails.setTotalFourStarRatings(fourStarRatings);
        reviewDetails.setTotalFiveStarRatings(fiveStarRatings);
        reviewDetails.setTotalRatings(totalRatings);

        double averageRating=(double) totalRatings/reviews.size(); //review 1-2-3-4-5

        reviewDetails.setAvgRatings(averageRating);
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
