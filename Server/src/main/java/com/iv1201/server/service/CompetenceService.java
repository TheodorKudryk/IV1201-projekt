package com.iv1201.server.service;

import com.iv1201.server.entity.Competence;
import com.iv1201.server.repository.CompetenceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository repository;
    
     public List<Competence> getCompetences() {
        return repository.findAll();
    }

}
