/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.service;

import com.iv1201.server.entity.Person;
import com.iv1201.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author theok
 */
@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
       Person user = repository.findByUsername(username);
       UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(user);
       return new User(userDetailsPrincipal.getUsername(),userDetailsPrincipal.getPassword(), userDetailsPrincipal.getAuthorities());
    }
    public Person loadUser(String username)throws UsernameNotFoundException{
       Person user = repository.findByUsername(username);
       return user;
    }
    
}