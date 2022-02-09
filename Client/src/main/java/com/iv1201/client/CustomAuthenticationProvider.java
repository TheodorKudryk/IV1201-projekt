package com.iv1201.client;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.Person;
import java.util.ArrayList;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        // You can get the password here
        String password = authentication.getCredentials().toString();

        Person person = DBHandler.validateLogin(name, password);
        
        // Your custom authentication logic here
        if (person != null) {
            Authentication auth = new UsernamePasswordAuthenticationToken(name,
                    password, new ArrayList<>());

            return auth;
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}