package com.iv1201.server.controller;

import com.iv1201.server.entity.Competence_profile;
import com.iv1201.server.service.Competence_profileService;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adds competences of user to database
 * @author theok
 */
@RestController 
public class Competence_profileController {
    @Autowired
    private Competence_profileService service;
    
    /**
     * Checks if the years of experience are possible and add them to the database
     * @param competence_profile info about years of experience and what area
     * @return message from API
     */
    @PostMapping("/addProfile")
    public String addProfile(@Valid @RequestBody Competence_profile competence_profile){
        System.out.println("check"+competence_profile);
        if (competence_profile.getYears_of_experience().compareTo(BigDecimal.ZERO) < 0 
                || competence_profile.getYears_of_experience().compareTo(BigDecimal.valueOf(100)) > 0)
            return "invalid number";
        service.saveCompetence_profile(competence_profile);
        return "OK";
    }
    @GetMapping("/applications/{id}")
    public List<Competence_profile> applications(@PathVariable int id){
        return service.getCompetence_profileById(id);
    }
}
