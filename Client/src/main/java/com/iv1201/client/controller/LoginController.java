package com.iv1201.client.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    /**
     * Controller for login page
     * @param model used for setting attributes in the view
     * @param login used for login errors
     * @param db used for when database is unreachable
     * @param error catch all error in case of unknown error
     * @return the view used
     */
    @RequestMapping(value = "/login")
    public String login(Model model, String login, String db, String error){
        if (isAuthenticated()) {
            return "redirect:startpage";
        }
        if(login != null){
            model.addAttribute("loginError", true);
        }
        else if(db != null){
            model.addAttribute("dbError", true);
        }
        else if(error != null){
            model.addAttribute("unknownError",true);
        }
        return "login";
    }
    
    @RequestMapping(value = "/startpage")
    public String startpage(HttpServletRequest request){
        if (request.isUserInRole("ROLE_recruiter")) {
            return "recruiter";
        }
        return "applicant";
    }
    
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
            isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}
