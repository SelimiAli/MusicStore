package com.example.musicstore.service;

import com.example.musicstore.model.Customer;
import com.example.musicstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Hent alle kunder
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Opret en ny kunde
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Hent en kunde ved ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Slet en kunde
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
