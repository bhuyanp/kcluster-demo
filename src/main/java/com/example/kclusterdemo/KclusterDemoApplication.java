package com.example.kclusterdemo;

import com.example.kclusterdemo.dto.CustomerRequest;
import com.example.kclusterdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KclusterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KclusterDemoApplication.class, args);
    }

    @Autowired
    CustomerService customerService;
    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return args-> {
            customerService.addCustomer(new CustomerRequest("Prasanta","Bhuyan","pbhuyan@gmail.com"));
            customerService.addCustomer(new CustomerRequest("P","Bhuyan","p.bhuyan@gmail.com"));
            customerService.addCustomer(new CustomerRequest("Prasant","B","bhuyanp@gmail.com"));
        };
    }

}
