package com.springboot.ecom.controller;

import com.springboot.ecom.dto.CustomerDto;
import com.springboot.ecom.model.Customer;
import com.springboot.ecom.service.CustomerService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
//->implements @Controller,@ResponseEntity
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
//    @GetMapping("/api/hello")
//    public String sayHello(){
//        return "Hello , Hey Buddy";
//    }
//    @GetMapping("/api/hello/private")
//    public String sayHelloPrivate(){
//        return "GOAT";
//    }
//    @GetMapping("api/customer/name")
//    public List<String>getCustomerName(){
//        return  List.of("gopi","hari","raja");
//    }



    private final CustomerService customerService;
    //@RequiredArgsConstructor

    @PostMapping("/add")
    public Customer add( @Valid @RequestBody CustomerDto dto){
        return customerService.add(dto);

    }
    @GetMapping
    public void getAll(){

    }
    @GetMapping
    public void getAllById(){

    }
    @PutMapping
    public  void update(){

    }
    @DeleteMapping
    public  void delete(){

    }

}
