/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.controller;

import com.iv1201.server.entity.Competence;
import com.iv1201.server.service.CompetenceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author theok
 */
@RestController 
public class CompetenceController {
    
    @Autowired
    private CompetenceService service;
    
    @GetMapping("/competences")
    public List<Competence> GetCompetences() {
        System.out.println("Kallad");
        return service.getCompetences();
    }
}
