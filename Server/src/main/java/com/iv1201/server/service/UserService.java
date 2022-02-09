package com.iv1201.server.service;

import com.iv1201.server.entity.User;
import com.iv1201.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author theok
 */
@Service
public class UserService{
    @Autowired
    UserRepository repository;

    public User loadUserByUsername(String username){
       return repository.findByUsername(username);
    }
    
}