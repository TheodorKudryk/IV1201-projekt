/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.service;

import com.iv1201.server.entity.Availability;
import com.iv1201.server.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author theok
 */
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository repository;
    
    public Availability saveAvailability(Availability profile) {
        return repository.save(profile);
    }
}
