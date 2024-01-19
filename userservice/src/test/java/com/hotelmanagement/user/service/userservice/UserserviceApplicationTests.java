package com.hotelmanagement.user.service.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelmanagement.user.service.userservice.entities.Rating;
import com.hotelmanagement.user.service.userservice.external.services.RatingService;


@SpringBootTest
class UserserviceApplicationTests {
	@Autowired
	private  RatingService ratingService;	
	@Test
	void createRatnig(){
		Rating rating = Rating.builder().hotelId("5f8b986d-83f5-4440-ac0a-86eb2bf46bf2").userId("8a3637a1-4a91-43a0-808f-226813feedbf").rating(5).remark("Remarks from tester").build();
		System.out.println("rating build up");
		System.out.println(rating);
		Rating savedRating = this.ratingService.createRatnig(rating);
		System.out.println(savedRating);
	}

}
