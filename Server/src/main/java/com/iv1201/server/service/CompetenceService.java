package com.iv1201.server.service;

import com.iv1201.server.entity.Competence;
import com.iv1201.server.repository.CompetenceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author theok
 */
@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository repository;
    
     public List<Competence> getCompetences() {
        return repository.findAll();
    }

}
