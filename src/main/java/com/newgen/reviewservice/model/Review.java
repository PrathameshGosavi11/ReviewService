package com.newgen.reviewservice.model;

import jakarta.persistence.*;

@Entity // tell here this is hibernate manage entity and this class now map to the Db
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
