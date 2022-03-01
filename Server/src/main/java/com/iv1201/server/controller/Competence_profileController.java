package com.iv1201.server.controller;

import com.iv1201.server.entity.Competence_profile;
import com.iv1201.server.service.Competence_profileService;
import javax.validation.Valid;
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
    public Competence_profile addProfile(@Valid @RequestBody Competence_profile competence_profile){
        return service.saveCompetence_profile(competence_profile);
    }
}
