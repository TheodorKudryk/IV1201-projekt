/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.service;

import com.iv1201.server.entity.Person;
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
    
    private Person user;
    
    public UserDetailsPrincipal(Person user){
        this.user = user;
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        return roles;
    }
    
    @Override
    public String getPassword(){
        System.out.println("Testar skriva ut");
        System.out.println(user.getPassword());
        System.out.println(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new BCryptPasswordEncoder().encode(user.getPassword());
    }
    
    @Override
    public String getUsername(){
        return user.getUsername();
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
