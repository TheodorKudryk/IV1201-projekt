/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.service;

import com.iv1201.server.entity.Competence_profile;
import com.iv1201.server.repository.Competence_profileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author theok
 */
@Service
public class Competence_profileService {
    
    @Autowired
    private Competence_profileRepository repository;
    
    public Competence_profile saveCompetence_profile(Competence_profile profile) {
        return repository.save(profile);
    }
}
