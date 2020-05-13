package com.techcret.TodoBackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
@Slf4j
public class TodoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoBackendApplication.class, args);
	}

}
