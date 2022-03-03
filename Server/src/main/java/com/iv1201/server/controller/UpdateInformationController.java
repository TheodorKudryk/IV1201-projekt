/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.controller;


import com.iv1201.server.entity.Password_reset_token;
import com.iv1201.server.entity.User;
import com.iv1201.server.service.PasswordResetService;
import com.iv1201.server.service.UserServiceImp;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Zarcez
 */
@RestController
public class UpdateInformationController {
    
    @Autowired
    private PasswordResetService service;
    
    @Autowired
    private UserServiceImp userService;
    
    @PostMapping(value = "/resetAccount/getToken")
    public String getToken(HttpServletRequest request, @RequestParam("email") String userEmail) {

        User user = userService.getUserByEmail(userEmail);
        if(user != null){
            if(user.getUsername() == null && user.getPassword() == null){
                String token = UUID.randomUUID().toString();
                service.createPasswordResetTokenForUser(userEmail, token);
                //mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, userEmail));
                System.out.println(token);
                return "ok";
            }
            return "already been reset";
        }
        return "invalid email";
    }
    
    @PostMapping(value = "/resetAccount/validateToken")
    public String validateToken(HttpServletRequest request, @RequestParam("token") String token) {
        Password_reset_token passToken = service.validatePasswordResetToken(token);
        if(passToken != null){
            return "ok";
        }
        return "No token";
    }
    
    @PostMapping(value = "/resetAccount/updateAccount")
    public String updateAccount(HttpServletRequest request, @RequestParam("username") String username,
            @RequestParam("password") String password, @RequestParam("token") String token) {
        Password_reset_token passToken = service.validatePasswordResetToken(token);
        User user = userService.getUserByEmail(passToken.getEmail());
        service.deleteToken(passToken);
        user.setUsername(username);
        user.setPassword(password);
        userService.updateUser(user);
        //service.createPasswordResetTokenForUser(userEmail, token);
        return "ok";
    }

}
