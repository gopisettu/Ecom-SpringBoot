package com.springboot.ecom.service;

import com.springboot.ecom.dto.CustomerDto;
import com.springboot.ecom.mapper.CustomerMapper;
import com.springboot.ecom.model.Customer;
import com.springboot.ecom.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private  final CustomerMapper customerMapper;


    public Customer add(CustomerDto dto) {
        Customer customer=customerMapper.getMapCustomerDto(dto);
        return  customerRepository.save(customer);




    }
}
