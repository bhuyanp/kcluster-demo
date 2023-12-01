package com.example.kclusterdemo.repo;

import com.example.kclusterdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
