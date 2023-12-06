package com.example.kclusterdemo;

import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

//@TestConfiguration
public class TestConfiguration {

    @Bean
    public MySQLContainer<?> mySQLContainer(){
        try(MySQLContainer<?> container = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.26"))){
            container.withDatabaseName("customer")
                    .withUsername("root")
                    .withUsername("example");
            container.start();
            return container;
        }
    }
}
