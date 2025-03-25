package com.newgen.reviewservice.controller;

import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")

public class ReviewController {

    private final IReviewService iReviewService;

    @Autowired
    public ReviewController(IReviewService iReviewService) {
        this.iReviewService = iReviewService;
    }

    @GetMapping("/{productId}/revies")
    public ResponseEntity<List<Review>> getAllReviewsByProductId(Long productId)
    {
        return ResponseEntity.status(HttpStatus.OK).body (iReviewService.getReviewsByProductId(productId));
    }

    

}
