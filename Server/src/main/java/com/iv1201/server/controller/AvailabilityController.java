/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.controller;


import com.iv1201.server.entity.Availability;
import com.iv1201.server.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author theok
 */
@RestController
public class AvailabilityController {
    @Autowired
    private AvailabilityService service;
    
    @PostMapping("/addAvailability")
    public String addAvailability(@RequestBody Availability availability){
        System.out.println("test dates"+availability.getFrom_date().before(availability.getTo_date()));
       if(!availability.getFrom_date().before(availability.getTo_date()))
           return "invalid dates";
       service.saveAvailability(availability);
       return "ok";     
    }
}
