package com.ateliers.ace.modelmapperdemo;

import com.ateliers.ace.modelmapperdemo.dtos.CustomerDto;
import com.ateliers.ace.modelmapperdemo.entities.Customer;
import com.ateliers.ace.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {

    @Autowired
    private CustomerMapper customerMapper;
    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            List<Customer> customers = new ArrayList<>();

            Customer customer1 = Customer.builder()
                    .id(1L)
                    .name("Alice Dupont")
                    .email("alice.dupont@example.com")
                    .password("password123")
                    .build();

            Customer customer2 = Customer.builder()
                    .id(2L)
                    .name("Bob Martin")
                    .email("bob.martin@example.com")
                    .password("securePass456")
                    .build();

            Customer customer3 = Customer.builder()
                    .id(3L)
                    .name("Charlie Durand")
                    .email("charlie.durand@example.com")
                    .password("charliePwd789")
                    .build();

            customers.add(customer1);
            customers.add(customer2);
            customers.add(customer3);

            customers.forEach(System.out::println);

            List<CustomerDto> customerdtoslist = customers.stream().map(customerMapper::fromCustomer).collect(Collectors.toList());
            customerdtoslist.forEach(System.out::println);

        };
    }
}
