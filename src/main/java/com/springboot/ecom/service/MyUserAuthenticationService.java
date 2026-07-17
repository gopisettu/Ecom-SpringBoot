package com.springboot.ecom.service;

import com.springboot.ecom.exception.ResourseNotFoundException;
import com.springboot.ecom.model.User;
import com.springboot.ecom.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MyUserAuthenticationService implements UserDetailsService {
    private  final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.loadUserByUsername(username)
                .orElseThrow(() -> new ResourseNotFoundException("User not found or disActivated"));

        return (UserDetails) user;
    }
}
