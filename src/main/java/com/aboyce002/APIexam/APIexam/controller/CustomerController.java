package com.aboyce002.APIexam.APIexam.controller;

import com.aboyce002.APIexam.APIexam.domains.Customer;
import com.aboyce002.APIexam.APIexam.response.ResponseStateReturn;
import com.aboyce002.APIexam.APIexam.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public ResponseEntity<?> getCustomers(){
        ResponseStateReturn rep = new ResponseStateReturn();
        List<Customer> customers = customerService.getCustomers();

        if(!customers.isEmpty()){
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Customers successfully retrieved");
            rep.setData(customers);
            return new ResponseEntity<>(rep, HttpStatus.OK);
        }else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            rep.setMessage("Error: No customers found");
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        ResponseStateReturn rep = new ResponseStateReturn();
        Optional<Customer> customer = customerService.getCustomerById(id);

        if(customer.isPresent()){
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Customer " + id + " successfully retrieved");
            rep.setData(customer);
            return new ResponseEntity<>(rep, HttpStatus.OK);
        }else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            rep.setMessage("Error: Customer not found");
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        ResponseStateReturn rep = new ResponseStateReturn();
        Customer c = customerService.addCustomer(customer);

        if(c != null){
            rep.setCode(HttpStatus.CREATED.value());
            rep.setMessage("Customer successfully added");
            rep.setData(c);
            return new ResponseEntity<>(rep, HttpStatus.CREATED);
        }
        else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            rep.setMessage("Error creating customer.");
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        ResponseStateReturn rep = new ResponseStateReturn();
        Customer c = customerService.updateCustomerInfo(customer, id);

        if(c != null){
            rep.setCode(HttpStatus.CREATED.value());
            rep.setMessage("Customer " + id + " successfully updated");
            rep.setData(c);
            return new ResponseEntity<>(rep, HttpStatus.CREATED);
        }
        else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            rep.setMessage("Error updating customer.");
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        ResponseStateReturn rep = new ResponseStateReturn();

        if(customerService.getCustomerById(id).isPresent()){
            customerService.deleteCustomerById(id);
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Customer " + id + " successfully deleted");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            rep.setMessage("Error: Customer for deletion not found.");
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }
}
