package com.boardagain.light10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Light10Application {

	public static void main(String[] args) {
		SpringApplication.run(Light10Application.class, args);
	}

}
