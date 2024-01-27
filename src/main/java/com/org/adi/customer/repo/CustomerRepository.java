package com.org.adi.customer.repo;

import com.org.adi.customer.domain.CustomerDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDomain, String> {
}
