
package com.iv1201.server.service;


import com.iv1201.server.entity.Password_reset_token;
import com.iv1201.server.repository.PasswordResetTokenRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
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