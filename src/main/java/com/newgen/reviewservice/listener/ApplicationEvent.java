//package com.newgen.reviewservice.listener;
//
//import com.newgen.reviewservice.dto.ReviewDTO;
//import com.newgen.reviewservice.service.IReviewService;
//import com.newgen.reviewservice.service.ReviewService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//@Slf4j
//public class ApplicationEvent {
//
//    final IReviewService iReviewService;
//
//    @Autowired
//    public  ApplicationEvent (IReviewService iReviewService)
//    {
//        this.iReviewService=iReviewService;
//    }
//    @EventListener(ApplicationEvent.class)
//    public void handleEvent(ApplicationEvent event)
//    {
//        log.info("Application ready to initilization");
//        initilizeReviews();
//    }
//
//    private void initilizeReviews() {
//        iReviewService.addReview(new ReviewDTO(1L,22L,4, "GOOD", "VERY EASY TO USE"));
//    }
//
//
//
//
//}
