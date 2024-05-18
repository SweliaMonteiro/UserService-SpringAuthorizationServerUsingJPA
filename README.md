# User Service using Spring Authorization Server and JWT (Database)

## Problem Statement

You are working on a project that requires you to create a user service. Implement the Spring Authorization Server to authenticate users and generate JWT tokens.

## Requirements
1. Use Spring Authorization Server to create a user service using documentation: [Spring Authorization Server](https://docs.spring.io/spring-authorization-server/reference/getting-started.html)
2. Add securityFilterChain to permit all requests to authorize and token endpoints. 
3. Modify SecurityConfiguration.java class to add multiple users, roles and clients to Database. 
4. Integrate it with Database using JPA by adding the required services, models and repositories to fetch the user and client details using documentation: [How-to: Implement core services with JPA](https://docs.spring.io/spring-authorization-server/reference/guides/how-to-jpa.html)
5. Create CustomUserDetails model to add custom user details from the database by implementing UserDetails Interface.
6. Create CustomGrantedAuthority model to add custom authorities/roles to the UserDetails from the database by implementing GrantedAuthority Interface.
7. Create CustomUserDetailsService by implementing UserDetailsService to load the user details using username/email from the database. Fetch the roles data of the user eagerly to create object of CustomUserDetails at the time of user authentication during login.
8. Modify SecurityConfiguration.java to customize JWT token using documentation: [How-to: Add authorities as custom claims in JWT access tokens](https://docs.spring.io/spring-authorization-server/reference/guides/how-to-custom-claims-authorities.html)
9. Add roles and user id to the JWT token as custom claims. 
10. Create one time test case to add custom client details to the database.
11. Add Postman application as a client with clientId: oidc-client, clientSecret: secret and scopes: openid, profile, ADMIN, STUDENT.
12. Use appropriate redirect URIs to redirect the user to the client(Postman) after login. 
13. For testing, use Authorization function available in Postman to get the JWT token by providing the required details like Client ID, Client Secret and Scope. 
14. Use the following endpoints in Postman to authenticate the user and generate the JWT token:
    - /oauth/authorize: This endpoint should authenticate the user and generate the JWT token. 
    - /oauth/token: This endpoint should generate the JWT token. 
15. Clicking on "Get New Access Token" should redirect the user to the login page where the user can enter the username and password to authenticate. Once authenticated, the user should be redirected to the client(Postman) with the JWT token.
