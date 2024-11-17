package com.ateliers.ace.modelmapperdemo.mappers;

import com.ateliers.ace.modelmapperdemo.dtos.CustomerDto;
import com.ateliers.ace.modelmapperdemo.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper{
    private ModelMapper mapper = new ModelMapper();
    public CustomerDto fromCustomer(Customer customer){
        return this.mapper.map(customer, CustomerDto.class);
    }
}
