package br.com.karloskelvin.shoppingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class ShoppingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiApplication.class, args);
	}

}
