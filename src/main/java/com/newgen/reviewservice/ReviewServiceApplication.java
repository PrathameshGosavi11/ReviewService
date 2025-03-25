package com.newgen.reviewservice;

import com.newgen.reviewservice.model.Review;
import com.newgen.reviewservice.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.logging.Logger;


@SpringBootApplication
@Slf4j
public class ReviewServiceApplication {



	public static void main(String[] args) {
	SpringApplication.run(ReviewServiceApplication.class, args);

	log.info("Hii start the application ");




	}

}
