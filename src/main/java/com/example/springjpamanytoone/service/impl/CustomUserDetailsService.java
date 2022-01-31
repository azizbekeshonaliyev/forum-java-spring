package com.example.springjpamanytoone.service.impl;

import com.example.springjpamanytoone.entity.User;
import com.example.springjpamanytoone.model.CustomUserDetails;
import com.example.springjpamanytoone.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser  = userRepository.findByEmail(username);
        System.out.println(optionalUser.toString());
        return optionalUser.map(CustomUserDetails::new).orElse(null);
    }
}
