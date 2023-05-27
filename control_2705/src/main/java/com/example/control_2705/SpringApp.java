package com.example.control_2705;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class SpringApp {

	public static void main(String[] args) {
		// SpringApplication.run(SpringApp.class, args);
		Application.launch(JavaFXApp.class, args);
	}

}
