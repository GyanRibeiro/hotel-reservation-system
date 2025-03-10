package com.desafiotecnico.eclipsehotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EclipseHotelApplication {

	@GetMapping("/helloword")
	public String helloWord() {
		return "Hello World!!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(EclipseHotelApplication.class, args);
	}

}
