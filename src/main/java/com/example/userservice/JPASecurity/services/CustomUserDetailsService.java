package com.example.userservice.JPASecurity.services;

import com.example.userservice.JPASecurity.models.CustomUserDetails;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;


// Create a CustomUserDetailsService class to implement the UserDetailsService interface

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from the database (throw exception if not found)
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with email " + username + " does not exist.");
        }
        // Else return a new CustomUserDetails object when trying to log in
        return new CustomUserDetails(optionalUser.get());
    }

}
