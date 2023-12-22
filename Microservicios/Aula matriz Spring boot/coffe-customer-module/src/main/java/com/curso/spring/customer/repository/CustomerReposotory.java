package com.curso.spring.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.spring.common.estities.Customer;

public interface CustomerReposotory extends JpaRepository<Customer, String> {

}
