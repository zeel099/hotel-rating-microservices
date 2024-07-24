package com.lcwd.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		System.out.println("Rating service...");
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
