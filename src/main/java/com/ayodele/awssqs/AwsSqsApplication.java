package com.ayodele.awssqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSqsApplication {

	public static final String QUEUE_NAME =  "simple-test-queue";

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsApplication.class, args);
	}

}
