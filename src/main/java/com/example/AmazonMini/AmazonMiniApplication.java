package com.example.AmazonMini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.AmazonMini.controllers.Usercontroller;
import com.example.AmazonMini.controllers.Productcontroller;

@SpringBootApplication
public class AmazonMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonMiniApplication.class, args);
	}

}
