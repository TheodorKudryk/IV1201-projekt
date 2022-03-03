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
        System.out.println("test");
        passwordTokenRepository.save(myToken);
    }
    
    public Password_reset_token validatePasswordResetToken(String token) {
        final Password_reset_token passToken = passwordTokenRepository.findByToken(token);
        if(passToken!=null) {
            return passToken;
        }
        return null;
        //return !isTokenFound(passToken) ? "invalidToken"
                //: isTokenExpired(passToken) ? "expired"
        //        : null;
    }

    private boolean isTokenFound(Password_reset_token passToken) {
        return passToken != null;
    }
    
    public void deleteToken(Password_reset_token token){
        passwordTokenRepository.deleteById(token.getId());
    }
    /*
    private boolean isTokenExpired(Password_reset_token passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
    */
}