/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iv1201.server.service;


import com.iv1201.server.entity.Password_reset_token;
import com.iv1201.server.entity.User;
import com.iv1201.server.repository.PasswordResetTokenRepository;
import java.util.Calendar;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Zarcez
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    public void createPasswordResetTokenForUser(final String email, final String token) {
        final Password_reset_token myToken = new Password_reset_token(token, email);
        passwordTokenRepository.save(myToken);
    }
    
    public Password_reset_token validatePasswordResetToken(String token) {
        final Password_reset_token passToken = passwordTokenRepository.findByToken(token);
        if(passToken!=null) {
            return passToken;
        }
        return null;
    }


    public Password_reset_token getPasswordToken(String email){
        return passwordTokenRepository.findByEmail(email);
    }
    
    public void deleteToken(Password_reset_token token){
        passwordTokenRepository.deleteById(token.getId());
    }

}