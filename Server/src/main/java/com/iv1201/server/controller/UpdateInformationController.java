
package com.iv1201.server.controller;


import com.iv1201.server.entity.Password_reset_token;
import com.iv1201.server.entity.User;
import com.iv1201.server.service.PasswordResetService;
import com.iv1201.server.service.UserServiceImp;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * A controller for all calls that deal with the methods that's part of resetting
 * an account
 * @author Zarcez
 */
@RestController
public class UpdateInformationController {
    
    @Autowired
    private PasswordResetService service;
    
    @Autowired
    private UserServiceImp userService;
    
    /**
     * Creates a token for a specific mail and saves it in the database. Only creates
     * a token if there is a user connected to the email and that user doesn't have
     * a username or password
     * @param request 
     * @param userEmail The mail that the user wants to reset account for
     * @return a message from the server
     */
    @PostMapping(value = "/resetAccount/getToken")
    public String getToken(HttpServletRequest request, @RequestParam("email") String userEmail) {

        User user = userService.getUserByEmail(userEmail);
        if(user != null){
            if(user.getUsername() == null && user.getPassword() == null){
                String token;
                Password_reset_token passtoken = service.getPasswordToken(userEmail);
                if(passtoken != null)
                    token = passtoken.getToken();
                else{
                    token = UUID.randomUUID().toString();
                    service.createPasswordResetTokenForUser(userEmail, token);
                }
                //Lack of proper mailing, for now only out print
                System.out.println("/userUpdate?token="+token);
                return "ok";
            }
            return "already been reset";
        }
        return "invalid email";
    }
    
    /**
     * Checks if there is token in the database that's the same as the one that
     * the user sent
     * @param request
     * @param token The token that the user sent
     * @return a message from the server
     */
    @PostMapping(value = "/resetAccount/validateToken")
    public String validateToken(HttpServletRequest request, @RequestParam("token") String token) {
        Password_reset_token passToken = service.validatePasswordResetToken(token);
        if(passToken != null){
            return "ok";
        }
        return "No token";
    }
    
    /**
     * Update the user that corresponds to the token with a new username and
     * password
     * @param request
     * @param username the new username that will be saved
     * @param password the new password that will be saved
     * @param token the token that is used to get the email connected to it
     * @return 
     */
    @PostMapping(value = "/resetAccount/updateAccount")
    public String updateAccount(HttpServletRequest request, @RequestParam("username") String username,
            @RequestParam("password") String password, @RequestParam("token") String token) {
        Password_reset_token passToken = service.validatePasswordResetToken(token);
        if(passToken == null)
            return null;
        User user = userService.getUserByEmail(passToken.getEmail());
        service.deleteToken(passToken);
        user.setUsername(username);
        user.setPassword(password);
        userService.updateUser(user);
        //service.createPasswordResetTokenForUser(userEmail, token);
        return "ok";
    }

}
