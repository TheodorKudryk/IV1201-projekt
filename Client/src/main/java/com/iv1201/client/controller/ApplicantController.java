package com.iv1201.client.controller;


import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.ApplicationDTO;
import java.net.ConnectException;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value = "/application")
    public String Applicantion(@RequestParam("competence") String competence, @RequestParam("experience") String experience, @RequestParam("begin")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date begin, @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end, @RequestParam("username") String username) throws ConnectException{
        ApplicationDTO applicationDTO = new ApplicationDTO(competence, experience, begin, end);
        System.out.println("check0");
        DBHandler.application(applicationDTO, username);
        return "redirect:/startpage";
    }
}
