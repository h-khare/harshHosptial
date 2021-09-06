package com.virus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HospitalsbedApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalsbedApplication.class, args);
	}

}
