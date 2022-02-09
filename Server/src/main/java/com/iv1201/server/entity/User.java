
package com.iv1201.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author theok
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class User implements Serializable {

    @Id
    @Column(name="person_id")
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String pnr;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    private String username;
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getPnr(){
        return pnr;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Role getRole(){
        return role;
    }
    
    public String getUsername(){
        return username;
    }
    
}

