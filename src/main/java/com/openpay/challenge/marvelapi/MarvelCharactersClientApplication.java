package com.openpay.challenge.marvelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.openpay.challenge.marvelapi", "com.example.backend"})
public class MarvelCharactersClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelCharactersClientApplication.class, args);
	}

}
