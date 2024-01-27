package com.org.adi.customer.domain;

import jakarta.persistence.Id;
import lombok.Data;

@Data

public class CustomerDomain {

    @Id
    public String customerId;

    public String firstName;

    public String lastName;

    public int age;

    public Contacts contacts;

    public boolean isActive;

    public boolean isGuest;


}
