package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author theok
 */
@Controller
public class ApplicantController {
    
    @RequestMapping(value = "/applicant")
    public String Applicant(ModelMap model, @RequestHeader("accept-language") String language){
        String[] langarray = language.split(",", 2);
        model.addAttribute("competences", DBHandler.loadCompetence(langarray[0]));
        return "applicant";
    }
    
}
