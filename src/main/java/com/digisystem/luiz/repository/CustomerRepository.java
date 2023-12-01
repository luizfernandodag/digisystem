package com.digisystem.luiz.repository;

import com.digisystem.luiz.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

   Customer findByNameAndEmail(String name, String email);

}