package com.example.firebase_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FirebaseCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirebaseCrudApplication.class, args);
	}

}
