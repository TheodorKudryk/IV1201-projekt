package com.iv1201.client.integration;

/**
 *
 * @author leohj
 */
public class DBHandler {
    
    public static boolean validateLogin(String username, String password) {
        return username.equals("leo") && password.equals("user1");
    }
    
}
