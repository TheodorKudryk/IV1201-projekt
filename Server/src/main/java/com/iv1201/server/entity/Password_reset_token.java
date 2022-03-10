
package com.iv1201.server.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password_reset_token")
public class Password_reset_token implements Serializable{
     
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    private Long id;
 
    private String token;

    private String email;

    public Password_reset_token(String token, String email) {
        this.token = token;
        this.email = email;
    }
    
}
