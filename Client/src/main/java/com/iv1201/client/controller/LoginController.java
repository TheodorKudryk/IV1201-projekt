package com.iv1201.client.controller;

import com.iv1201.client.integration.DBHandler;
import java.sql.SQLException;
import com.iv1201.client.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping; // for mapping request path to invoking method
import org.springframework.web.bind.annotation.RequestMethod; // for mapping request method (GET, POST) to controller method 
import org.springframework.web.bind.annotation.RequestParam; // for retrieving HTTP parameters sent (GET, POST)
import org.springframework.web.bind.annotation.SessionAttributes; // same as setattribute on a HttpSession-object

@SessionAttributes("Subject")
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(){ //method name is not mapped
        //return ("<h1>Welcome</h1>");
        return "login"; // return filename without ".jsp" for jsp-pages in WEB-INF/jsp
    }
   

    
}
