package com.iv1201.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author theok
 */
@Controller
public class ApplicantController {
    
    @RequestMapping(value = "/applicant")
    public String Applicant(){
        return "redirect:/startpage";
    }
    
}
