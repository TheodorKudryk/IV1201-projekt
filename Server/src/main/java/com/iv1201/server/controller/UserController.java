/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.controller;

import com.iv1201.server.entity.User;
import com.iv1201.server.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostMapping("/login")
    public String login() {
        return "welcome";
    }
    
    @GetMapping("/user/{uname}")
    public User findUserByUsername(@PathVariable String uname) {
        return service.loadUser(uname);
    }
    
}
