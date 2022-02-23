/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.UserDTO;
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
        DBHandler.updateUser(user);
        return "applicant";
    }
    
    @RequestMapping(value = "/userupdate")
    public String userUpdate(){
        return "userupdate";
    }
}
