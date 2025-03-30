package com.newgen.reviewservice.model;

import com.newgen.reviewservice.dto.ReviewDTO;
import lombok.Data;

import java.util.List;

@Data
public class ReviewDetails
{
    private int totalOneStarRatings;
    private int totalTwoStarRatings;
    private int totalThreeStarRatings;
    private  int totalFourStarRatings;
    private int totalFiveStarRatings;

    private  int totalRatings;
    private double avgRatings;

    private List<ReviewDTO> reviews;


}
