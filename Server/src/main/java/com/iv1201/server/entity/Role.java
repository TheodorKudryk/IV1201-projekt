/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author theok
 */
@Entity
@Table(name = "role")
public class Role {
    
    @Id
    @Column(name="role_id")
    private int id;
    private String name;
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
}
