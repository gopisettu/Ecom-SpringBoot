package com.springboot.ecom.controller;

import com.springboot.ecom.dto.AdminDto;
import com.springboot.ecom.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping("/api/admin/add")
    public void addAdmin(@RequestBody AdminDto adminDto){
        userService.addAdmin(adminDto);

    }
}
