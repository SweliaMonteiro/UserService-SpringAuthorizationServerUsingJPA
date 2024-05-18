package com.example.userservice.JPASecurity.models;

import com.example.userservice.models.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


// Create a CustomGrantedAuthority class to add custom authorities/roles to the UserDetails

@JsonDeserialize  // To deserialize the JSON to the CustomGrantedAuthority class object when the JSON is received from the client over the network otherwise it will throw an error
@NoArgsConstructor  // To create a no-argument constructor in the CustomGrantedAuthority class else it will throw an error
public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;  // authority means role

    // To convert Role to authority
    public CustomGrantedAuthority(Role role) {
        this.authority = role.getValue();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
