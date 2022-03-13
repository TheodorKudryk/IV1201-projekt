
package com.iv1201.server.controller;


import com.iv1201.server.entity.Availability;
import com.iv1201.server.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adds available dates sent from user
 * @author theok
 */
@RestController
public class AvailabilityController {
    @Autowired
    private AvailabilityService service;
    
    /**
     * Checks if dates are correct and adds them
     * @param availability day available
     * @return message from API
     */
    @PostMapping("/addAvailability")
    public String addAvailability(@RequestBody Availability availability){
       if(!availability.getFrom_date().before(availability.getTo_date()))
           return "invalid dates";
       service.saveAvailability(availability);
       return "ok";     
    }
}
