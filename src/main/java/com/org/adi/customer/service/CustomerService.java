package com.org.adi.customer.service;

import com.org.adi.customer.domain.CustomerDomain;
import com.org.adi.customer.domain.CustomerDto;
import com.org.adi.customer.domain.CustomerRequest;
import com.org.adi.customer.domain.CustomerResponse;
import com.org.adi.customer.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse newCustomer(CustomerRequest customerRequest, Boolean isGuest){
        if(isGuest){
            log.info("Adding Guest Customer");
            return new CustomerResponse("Customer Created");

        }else {
            log.info("Creating new Customer");

            CustomerDomain customer = new CustomerDomain();
            customer.setCustomerId(UUID.randomUUID().toString());
            customer.setAge(customerRequest.getAge());
            customer.setFirstName(customerRequest.getFirstName());
            customer.setLastName(customerRequest.getLastName());
            customer.setIsActive(Boolean.TRUE);
            customer.setIsGuest(Boolean.FALSE);
            this.customerRepository.save(customer);
            return new CustomerResponse("Customer Created");
        }
    }

    public CustomerDto byName(String name){
        log.info("Getting customer by name");
        CustomerDomain byFirstName = this.customerRepository.findByFirstName(name);
        log.info("customer by name Okay");
        return new CustomerDto(byFirstName.getFirstName(), byFirstName.getLastName(), byFirstName.getAge(), null);

    }
}
