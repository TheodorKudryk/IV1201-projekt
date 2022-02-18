/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author theok
 */
@Controller
public class ApplicantController {
    
    @RequestMapping(value = "/applicant")
    public String Applicant(ModelMap model){    
        ApplicantController.addModelAttributes(model);
        return "applicant";
    }
    
    private static void addModelAttributes(ModelMap model) {
        model.addAttribute("user", DBHandler.loadUser("JoelleWilkinson"));
    }
}
