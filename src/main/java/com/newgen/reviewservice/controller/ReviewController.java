package com.newgen.reviewservice.controller;

import com.newgen.reviewservice.dto.ReviewDTO;
import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.model.ReviewDetails;
import com.newgen.reviewservice.service.IReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ReviewController {

    private final IReviewService iReviewService;

    @Autowired
    public ReviewController(IReviewService iReviewService) {
        this.iReviewService = iReviewService;
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<ReviewDetails> getAllReviewsByProductId(@PathVariable Long productId)
    {
        log.info("request come on the controller");

        return ResponseEntity.status(HttpStatus.OK).body (iReviewService.getReviewsByProductId(productId));
    }

    @PostMapping("/{productId}/review")
    public ResponseEntity<Void> addReview(@PathVariable Long productId,@RequestBody ReviewDTO reviewDTO)
    {
        log.info("Request come on the controoller add request ");
        reviewDTO.setProductId(productId);
        iReviewService.addReview(reviewDTO);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{productId}/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable Long productId, @PathVariable Long reviewId)
    {
        log.info("Request come on the controller");
          iReviewService.deleteReview(productId,reviewId);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
