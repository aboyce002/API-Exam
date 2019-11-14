package com.aboyce002.APIexam.APIexam.services;

import com.aboyce002.APIexam.APIexam.domains.Customer;
import com.aboyce002.APIexam.APIexam.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        List<Customer> listOfCustomers = new ArrayList<>();
        customerRepository.findAll().forEach(listOfCustomers::add);

        return listOfCustomers;
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer){ return customerRepository.save(customer); }

    public Customer updateCustomerInfo(Customer customer, Long id){
        return customerRepository.save(customer);
    }

    public void deleteCustomerById( Long id ){
        customerRepository.deleteById(id);
    }
}
