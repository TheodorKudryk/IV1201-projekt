/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.controller;

import com.iv1201.server.entity.Competence_profile;
import com.iv1201.server.service.Competence_profileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author theok
 */
@RestController 
public class Competence_profileController {
    @Autowired
    private Competence_profileService service;
    
    @PostMapping("/addProfile")
    public Competence_profile addProfile(@RequestBody Competence_profile competence_profile){
        return service.saveCompetence_profile(competence_profile);
    }
}
