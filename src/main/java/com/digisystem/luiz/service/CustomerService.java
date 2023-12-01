package com.digisystem.luiz.service;

import com.digisystem.luiz.model.Customer;
import com.digisystem.luiz.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, Customer updatedCust) {
        customerRepository
                .findById(id) // returns Optional<User>
                .ifPresent(cust-> {
                    cust.setName(updatedCust.getName());;
                    cust.setEmail(updatedCust.getEmail());;


                    customerRepository.save(cust);
                });
    }
}
