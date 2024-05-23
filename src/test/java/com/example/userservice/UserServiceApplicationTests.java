package com.example.userservice;

import com.example.userservice.JPASecurity.repositories.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import java.util.UUID;


@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;

    // Comment this code when running from AWS Cloud
    // Run only one time to add the sample registered client
    // Use the code from the SecurityConfig.java file which is used to create RegisteredClientRepository
    @Test
    public void addSampleRegisteredClient() {
        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
                // Use "oidc-client" as client ID
                .clientId("oidc-client")
                // Use BCrypt password encoder strategy to encode the "clientSecret" as default encoder strategy is BCrypt
                .clientSecret("$2a$12$iQIr/X0WnLTwCYfBmR3c2etPo7a/iv85oe.xw1MOs8HZdAlFkutnG")
                // Authorization code flow and refresh token grant type
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                // Redirect URI and post logout redirect URI are used to redirect the user to the client after login and logout
                .redirectUri("https://oauth.pstmn.io/v1/callback")
                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
                // Scope provide the access to user profile information to the client
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .scope("ADMIN")
                .scope("STUDENT")
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .build();
        jpaRegisteredClientRepository.save(oidcClient);
    }


    @Test
    void contextLoads() {
    }

}
