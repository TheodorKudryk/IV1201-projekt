/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "competence")
public class Competence {
    @Id
    @Column(name="competence_id")
    @GeneratedValue
    private int id;
    private String name;
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    
    
}
