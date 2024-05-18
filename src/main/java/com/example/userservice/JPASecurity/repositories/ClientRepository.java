package com.example.userservice.JPASecurity.repositories;

import com.example.userservice.JPASecurity.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


// Copy this interface from How-to: Implement core services with JPA documentation: https://docs.spring.io/spring-authorization-server/reference/guides/how-to-jpa.html

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}
