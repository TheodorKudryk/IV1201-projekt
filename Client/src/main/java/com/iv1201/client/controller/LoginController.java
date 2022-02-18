package com.iv1201.client.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; // for mapping request path to invoking method

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String start(){
        return "login";
    }
    
    @RequestMapping(value = "/startpage")
    public String startpage(HttpServletRequest request){
        if (request.isUserInRole("ROLE_recruiter")) {
            return "recruiter";
        }
        return "applicant";
    }
}
