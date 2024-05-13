package com.example.userservice.JPASecurity.services;

import com.example.userservice.JPASecurity.models.CustomUserDetails;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@JsonDeserialize
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with email " + username + " does not exist.");
        }
        return new CustomUserDetails(optionalUser.get());
    }
}
