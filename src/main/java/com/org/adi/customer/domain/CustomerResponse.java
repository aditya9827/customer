package com.org.adi.customer.domain;

import lombok.Data;

@Data
public class CustomerResponse {

    public String message;

    public CustomerResponse(String message) {
        this.message = message;
    }
}
