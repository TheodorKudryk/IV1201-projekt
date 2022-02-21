package com.iv1201.client.security;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.Person;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    /**
     * Custom Authentication as to handle the username and password on the 
     * database side instead of browser side.
     */
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        try {

            String username = authentication.getName();
            // You can get the password here
            String password = authentication.getCredentials().toString();

            Person person = DBHandler.validateLogin(username, password);
            System.out.println(person.getName() + person.getRole());
            // Checks if there vas a resonse from the server and creates and auth
            // with the values
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_"+person.getRole()));
            Authentication auth = new UsernamePasswordAuthenticationToken(username,
                password, authorities);
        }
        catch(NullPointerException ex){
            throw new BadCredentialsException("invalid login details");  
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}