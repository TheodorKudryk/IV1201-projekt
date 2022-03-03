package com.iv1201.server.controller;

import com.iv1201.server.entity.User;
import com.iv1201.server.service.UserServiceImp;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author theok
 */
@RestController 
@RequiredArgsConstructor
public class UserController {
    
    @Autowired
    private UserServiceImp service;
    
    @GetMapping("/user/{uname}")
    public User findUserByUsername(@Valid @PathVariable String uname) {
        return service.loadUser(uname);
    }
    
}
