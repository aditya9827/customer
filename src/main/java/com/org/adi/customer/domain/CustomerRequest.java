package com.org.adi.customer.domain;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
public class CustomerRequest {

    @NonNull
    public String firstName;

    @NonNull
    public String lastName;

    @NonNull
    public int age;

    @NonNull
    public String mobileNumber;

    @NonNull
    public String emailId;

    @NonNull
    public String address;
}
