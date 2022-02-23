package com.example.task11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* Войдите в режим командной строки (команда cmd), перейдите в папку с pom.xml и введите команду mvn clean package
  Maven cгенерирует исполняемый jar-файл с именем SpringBootRestService-1.0.jar
  Перейдите в папку cd target
  Затем запустите jar-файл: java -jar task11-0.0.1-SNAPSHOT.jar
  Перейдите в браузере по адресу http://localhost:8080/
*
* */

// ./mvnw spring-boot:run

@SpringBootApplication
public class Task11Application {

	public static void main(String[] args) {
		SpringApplication.run(Task11Application.class, args);
	}

}
