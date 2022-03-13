package com.iv1201.server.service;

import com.iv1201.server.entity.Competence_profile;
import com.iv1201.server.repository.Competence_profileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class Competence_profileService {
    
    @Autowired
    private Competence_profileRepository repository;
    
    public Competence_profile saveCompetence_profile(Competence_profile profile) {
        return repository.save(profile);
    }
    
    public List<Competence_profile> getCompetence_profileById(int id) {
        return repository.findAllById(id);
    }
}
