package com.sourabhsurve.SBT_RabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbtRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtRabbitMqApplication.class, args);
		System.out.println("Connected....");
	}

}
