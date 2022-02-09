package com.iv1201.client;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.Person;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Person person = DBHandler.loadPerson(username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }
        //UserDetails user = User.withUsername(person.getUsername()).password(person.getPassword()).authorities("USER").build();
        
        UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(person);
        return userDetailsPrincipal;
    }
}
