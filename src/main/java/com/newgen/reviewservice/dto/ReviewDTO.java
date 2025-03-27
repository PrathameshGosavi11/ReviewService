package com.newgen.reviewservice.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {


    private Long reviewId;

    private  Long userId;

    private  Long productId;

    private int ratings;

    private String title;

    private String description;

    //audit
    private LocalDateTime createdAt;

}
