/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.controller;

import com.iv1201.server.entity.User;
import com.iv1201.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author theok
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService service;
    
    
    @GetMapping("/user/{uname}")
    public User findUserByUsername(@PathVariable String uname) {
        return service.loadUserByUsername(uname);
    }
    
}
