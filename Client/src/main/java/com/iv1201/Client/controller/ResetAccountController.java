/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.Client.controller;

import com.iv1201.client.integration.DBHandler;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Zarcez
 */
@Controller
public class ResetAccountController {

    @RequestMapping(value = "/resetAccount", method = RequestMethod.GET)
    public String resetAccount(Model model){
        return "resetaccount";
    }
    
    @RequestMapping(value = "/resetAccount", method = RequestMethod.POST)
    public String resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail) {
        String test = "";
        try {
            test = DBHandler.validateEmail(userEmail);
        } catch (ConnectException ex) {

        }
        System.out.println(test);
        return "resetaccount";
    }

}
