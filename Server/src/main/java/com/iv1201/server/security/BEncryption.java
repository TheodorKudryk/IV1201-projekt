/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iv1201.server.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author theok
 */
public class BEncryption {
    public static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
}
