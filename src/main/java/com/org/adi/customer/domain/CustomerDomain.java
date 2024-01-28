package com.org.adi.customer.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="CORE_CUSTOMER")
public class CustomerDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    public String customerId;

    @Column(name = "FNAME")
    public String firstName;

    @Column(name = "LNAME")
    public String lastName;

    @Column(name = "AGE")
    public int age;

    //public Contacts contacts;

    @Column(name = "ACTIVE")
    public Boolean isActive;

    @Column(name = "GUEST")
    public Boolean isGuest;


}
