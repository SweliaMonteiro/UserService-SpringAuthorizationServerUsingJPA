package com.example.userservice.JPASecurity.repositories;

import java.util.Optional;
import com.example.userservice.JPASecurity.models.AuthorizationConsent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Copy this interface from How-to: Implement core services with JPA documentation: https://docs.spring.io/spring-authorization-server/reference/guides/how-to-jpa.html

@Repository
public interface AuthorizationConsentRepository extends JpaRepository<AuthorizationConsent, AuthorizationConsent.AuthorizationConsentId> {
    Optional<AuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
