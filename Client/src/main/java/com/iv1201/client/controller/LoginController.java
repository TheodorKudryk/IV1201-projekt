package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.Person;
import java.sql.SQLException;
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
    
    @RequestMapping(value = "/hi")
    public String hi(){
        return "hi";
    }
    /*
    @RequestMapping(value = "/loginAttempt", method = RequestMethod.POST)
    public String loginAttempt(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
        Person person = DBHandler.validateLogin(username, password);
        if (person != null)
            return "startpage";
        else
            return "login";
    }
    */
}
