package com.iv1201.client;

import com.iv1201.client.model.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author theok
 */
public class UserDetailsPrincipal implements UserDetails{
    
    private Person person;
    
    public UserDetailsPrincipal(Person person){
        this.person = person;
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + person.getRole()));
        return roles;
    }
    
    @Override
    public String getPassword(){
        System.out.println("Testar skriva ut");
        System.out.println(person.getPassword());
        System.out.println(new BCryptPasswordEncoder().encode(person.getPassword()));
        return new BCryptPasswordEncoder().encode(person.getPassword());
    }
    
    @Override
    public String getUsername(){
        return person.getUsername();
    }
    
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    
    public boolean isCredentialsNonExpired(){
        return true;
    }
    
    public boolean isEnabled(){
        return true;
    }

    
}
