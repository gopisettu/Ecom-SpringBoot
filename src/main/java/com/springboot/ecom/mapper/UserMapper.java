package com.springboot.ecom.mapper;

import com.springboot.ecom.enums.Role;
import com.springboot.ecom.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public   static User mapUserDtoToEntity(String username, String password, Role role){
        User user=new User();
        user.setRole(role);
        user.setUsername(username);
        user.setPassword(password);
        user.setActive(true);
        return user;
    }
}