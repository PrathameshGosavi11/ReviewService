package com.newgen.reviewservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // tell here this is hibernate manage entity and this class now map to the Db
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  Long userId;

    private  Long productId;

    private int ratings;

    private String title;

    private String description;

    //audit
    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
