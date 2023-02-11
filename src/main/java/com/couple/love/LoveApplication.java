package com.couple.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoveApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoveApplication.class, args);
	}
}
