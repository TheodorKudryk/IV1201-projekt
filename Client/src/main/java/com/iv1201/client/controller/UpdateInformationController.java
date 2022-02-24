/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.UserDTO;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author theok
 */
@Controller
public class UpdateInformationController {
    
    @RequestMapping(value = "/updateinformation")
    public String updateInformation(UserDTO user){
        if (isAuthenticated()) {
            return "redirect:startpage";
        }
        DBHandler.updateUser(user);
        return "applicant";
    }
    
    @RequestMapping(value = "/userupdate")
    public String userUpdate(){
        return "userupdate";
    }
    
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}
