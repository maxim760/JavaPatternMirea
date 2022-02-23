package com.example.task12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// mvn spring-boot:run -Dspring-boot.run.arguments="--from=from.txt --to=to.txt"

@SpringBootApplication
public class Task12Application {

	public static void main(String[] args) {
		SpringApplication.run(Task12Application.class, args);
	}

}
