/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iv1201.server.repository;

/**
 *
 * @author Zarcez
 */

import com.iv1201.server.entity.Password_reset_token;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PasswordResetTokenRepository extends JpaRepository<Password_reset_token, Long> {

    Password_reset_token findByToken(String token);

    Password_reset_token findByEmail(String email);
}