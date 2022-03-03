package com.iv1201.server.controller;

import com.iv1201.server.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author leohj
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findUserByUsername method, of class UserController.
     */
    @Test
    public void testFindUserByUsername() {
        String uname = "";
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.findUserByUsername(uname);
        assertEquals(expResult, result);
    }
    
}
