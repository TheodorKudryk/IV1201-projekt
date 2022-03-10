package com.iv1201.server.service;

import com.iv1201.server.entity.User;
import java.util.List;


public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    List<User>getUsers();
    User getUserByEmail(String Email);
}
