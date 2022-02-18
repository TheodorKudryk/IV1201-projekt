/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.service;

import com.iv1201.server.entity.User;
import java.util.List;

/**
 *
 * @author theok
 */
public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    List<User>getUsers();
}
