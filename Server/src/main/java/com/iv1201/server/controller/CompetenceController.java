package com.iv1201.server.controller;

import com.iv1201.server.entity.Competence;
import com.iv1201.server.service.CompetenceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
        return service.getCompetences();
    }
}
