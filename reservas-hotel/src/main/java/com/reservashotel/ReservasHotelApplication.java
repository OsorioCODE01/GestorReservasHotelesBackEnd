package com.reservashotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan("com.reservashotel.model.entities")
public class ReservasHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasHotelApplication.class, args);
	}

}
