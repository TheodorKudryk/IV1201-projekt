package com.iv1201.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    
    @NotBlank
    @Size(min = 2, max = 100, message = "name is either to long or too short")
    private String name;
    
    @NotBlank
    @Size(min = 2, max = 100, message = "surname is either to long or too short")
    private String surname;
    
    @NotBlank
    @Size(min = 10, max = 20, message = "pnr is not valid")
    private String pnr;
    
    @Email
    @Size(min = 2, max = 100, message = "email has incorrect format")
    private String email;
    
    @NotBlank
    @Size(min = 2, max = 100, message = "password is either to long or too short")
    private String password;
    
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    
    @NotBlank
    @Size(min = 2, max = 100, message = "username is either to long or too short")
    private String username;
}

