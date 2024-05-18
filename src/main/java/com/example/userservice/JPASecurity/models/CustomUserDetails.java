package com.example.userservice.JPASecurity.models;

import com.example.userservice.models.Role;
import com.example.userservice.models.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;


// Create a CustomUserDetails class to add custom user details to the UserDetails

@JsonDeserialize  // To deserialize the JSON to the CustomUserDetails class object when the JSON is received from the client over the network otherwise it will throw an error
@NoArgsConstructor  // To create a no-argument constructor in the CustomUserDetails class else it will throw an error
@Getter
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<CustomGrantedAuthority> authorities;  // authorities means roles
    private long userId;  // To create a custom user id

    // To convert User to UserDetails
    public CustomUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getHashedPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.userId = user.getId();
        this.authorities = new ArrayList<>();
        for(Role role : user.getRoles()) {
            this.authorities.add(new CustomGrantedAuthority(role));
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
