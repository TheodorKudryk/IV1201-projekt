package com.iv1201.client.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class for saving info about a users username, password and their email
 * @author theok
 */
public class UserDTO {
    
    @NotNull
    @Size(min=2, max=30)
    private String username;
    
    @NotNull
    @Size(min=2, max=30)
    private String password;
    /*
    public UserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
    }
*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
