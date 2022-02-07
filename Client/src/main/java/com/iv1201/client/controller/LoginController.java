package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import java.sql.SQLException;
import com.iv1201.client.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; // for mapping request path to invoking method
import org.springframework.web.bind.annotation.RequestMethod; // for mapping request method (GET, POST) to controller method 
import org.springframework.web.bind.annotation.RequestParam; // for retrieving HTTP parameters sent (GET, POST)
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes; // same as setattribute on a HttpSession-object

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String start(){
        return "login";
    }
    
    @RequestMapping(value = "/loginAttempt", method = RequestMethod.POST)
    public String loginAttempt(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
        if (DBHandler.validateLogin(username, password))
            return "startpage";
        else
            return "login";
    }
    
}
