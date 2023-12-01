package com.example.kclusterdemo.service;

import com.example.kclusterdemo.dto.CustomerRequest;
import com.example.kclusterdemo.model.Customer;
import com.example.kclusterdemo.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer addCustomer(CustomerRequest customerRequest) {
        return customerRepo.save(Customer.builder()
                .firstName(customerRequest.fistName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build()
        );
    }
}
