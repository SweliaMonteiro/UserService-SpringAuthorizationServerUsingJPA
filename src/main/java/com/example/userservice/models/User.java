package com.example.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@Entity
public class User extends BaseModel {

    private String name;

    private String email;

    private String hashedPassword;

    // Eager fetch type is used to load all roles when user is loaded else it will throw error when we try to log in using user credentials stored in DB as it will not load roles to add authorities to custom UserDetails
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    private boolean isEmailVerified;

}
