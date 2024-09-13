package com.gts.timezone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GTSTimeZonesService {

	public static void main(String[] args) {
		
		SpringApplication.run(GTSTimeZonesService.class, args);
		System.out.println(" Service got started");
	}

}
