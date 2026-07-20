package com.springboot.ecom.Service;

import com.springboot.ecom.dto.CustomeResDto;
import com.springboot.ecom.enums.Role;
import com.springboot.ecom.exception.ResourseNotFoundException;
import com.springboot.ecom.mapper.CustomerMapper;
import com.springboot.ecom.model.Customer;
import com.springboot.ecom.model.User;
import com.springboot.ecom.repository.CustomerRepository;
import com.springboot.ecom.repository.UserRepository;
import com.springboot.ecom.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private UserRepository userRepository;
    private Customer customer1;
     User user1;
    @BeforeEach
    public  void init(){
        user1 = new User(1L,true,"hari@gmail.com","hari@123",Role.ADMIN);
        customer1 = new Customer(1L,"John Doe","hubli",true, user1);
    }

    @Test
    public void getByIdPresent(){
    when(customerRepository.findById(9L)).thenReturn(Optional.of(customer1));
        CustomeResDto customeResDto= CustomerMapper.mapEntityToDto(customer1);

        Assertions.assertEquals(customeResDto,customerService.getAllById(9L));
        verify(customerRepository, times(1)).findById(9L);
    }
    @Test public void getByIdNotPresent(){
        when(customerRepository.findById(9L)).thenReturn(Optional.empty());
//        Assertions.assertEquals("Customer Id not found",customerService.getAllById(9000L));
        Assertions.assertEquals("Customer Id not found",
                Assertions.assertThrows(ResourseNotFoundException.class, ()-> {
                    customerService.getAllById(9L);
                }).getMessage() );

        verify(customerRepository,times(1)).findById(9L);
    }

}
