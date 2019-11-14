package com.aboyce002.APIexam.APIexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApIexamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApIexamApplication.class, args);
	}

	/*
    Create an API with one endpoint, /customers
    Customer should have ID, name, Address
    A customer can only have one Address, which is an object
    Needs all the CRUD functionalities
    Needs a database
    Service layer b/c single-responsibility
    ResponseEntity and status codes
    Use h2 dependency, then put something in the properties file to connect to the db.
 */
}
