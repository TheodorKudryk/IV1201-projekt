package com.iv1201.Client.integration;

import com.iv1201.client.integration.DBHandler;
import com.iv1201.client.model.ApplicationDTO;
import com.iv1201.client.model.Competence;
import com.iv1201.client.model.Person;
import com.iv1201.client.model.UserDTO;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leohj
 */
public class DBHandlerTest {
    
    public DBHandlerTest() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateLogin method, of class DBHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateLoginRecruiter() throws Exception {
        String username = "JoelleWilkinson";
        String password = "LiZ98qvL8Lw";
        String expResult = "Joelle";
        Person resultPerson = DBHandler.validateLogin(username, password);
        assertEquals(expResult, resultPerson.getName());
    }
    
    /**
     * Test of validateLogin method, of class DBHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateLoginApplicant() throws Exception {
        String username = "LeroyCrane";
        String password = "1234";
        String expResult = "Leroy";
        Person resultPerson = DBHandler.validateLogin(username, password);
        assertEquals(expResult, resultPerson.getName());
    }

    /**
     * Test of validateLogin method, of class DBHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateLoginEmptyInputs() throws Exception {
        String username = "";
        String password = "";
        String expResult = null;
        Person resultPerson = DBHandler.validateLogin(username, password);
        assertEquals(expResult, resultPerson);
    }
    
    /**
     * Test of validateLogin method, of class DBHandler.
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateLoginWrongInputs() throws Exception {
        String username = "wrongUsername";
        String password = "wrongPassword";
        String expResult = null;
        Person resultPerson = DBHandler.validateLogin(username, password);
        assertEquals(expResult, resultPerson);
    }
}
