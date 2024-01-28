package com.org.adi.customer.controller;

import com.org.adi.customer.domain.CustomerRequest;
import com.org.adi.customer.domain.CustomerResponse;

import com.org.adi.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(path = "/health")
    public String helloWorld(){
        return "Hello World!!!";
    }

    @PostMapping(path = "/customer")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
            CustomerResponse customerResponse = this.service.newCustomer(customerRequest, true);
            return ResponseEntity.ok(customerResponse);
    }
}
