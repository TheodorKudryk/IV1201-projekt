/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.repository;

import com.iv1201.server.entity.Role;
import com.iv1201.server.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author theok
 */
public interface UserRepository extends JpaRepository<Person,Integer> {
    Person findByUsername(String username);
}
