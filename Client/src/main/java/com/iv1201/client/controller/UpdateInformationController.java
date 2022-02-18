/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author theok
 */
@Controller
public class UpdateInformationController {
    
    @RequestMapping(value = "/updateinformation")
    public String updateinformation(UserDTO user){
        System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getUsername());
        DBHandler.updateUser(user);
        return "applicant";
    }
    @RequestMapping(value = "/userupdate")
    public String userUpdate(){
        return "userupdate";
    }
}
