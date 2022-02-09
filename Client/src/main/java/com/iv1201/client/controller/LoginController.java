package com.iv1201.client.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; // for mapping request path to invoking method

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String start(){
        return "login";
    }
    
    @RequestMapping(value = "/startpage")
    public String startpage(){
        return "startpage";
    }
}
