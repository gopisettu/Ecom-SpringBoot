package com.springboot.ecom.controller;

import com.springboot.ecom.dto.Executive.ExecutiveUserDto;
import com.springboot.ecom.repository.ExecutiveRepository;
import com.springboot.ecom.service.ExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/executive")
   /*
    Executive with User
    Body:
    {
        name : "",
        jobTitle : "",
        username : "",
        password: ""
    }
    * */
public class ExecutiveController {
    private  final ExecutiveService executiveService;
    @PostMapping("/insert/executiveUser")
    public  void insertExecutiveUser(@RequestBody ExecutiveUserDto executiveUserDto){
         executiveService.insert(executiveUserDto);

    }


    @PostMapping("/insert/executiveUser/prof")
    public  void insertExecutiveUserProf( @Valid  @RequestBody ExecutiveUserDto executiveUserDto){
        executiveService.insertProf(executiveUserDto);

    }


}
