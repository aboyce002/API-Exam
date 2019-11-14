package com.aboyce002.APIexam.APIexam.repository;

import com.aboyce002.APIexam.APIexam.domains.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> { }
