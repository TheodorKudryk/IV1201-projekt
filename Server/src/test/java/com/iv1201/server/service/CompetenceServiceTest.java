package com.iv1201.server.service;

import com.iv1201.server.entity.Competence;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author leohj
 */
public class CompetenceServiceTest {
    
    CompetenceService instance;
    
    public CompetenceServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new CompetenceService();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getCompetences method, of class CompetenceService.
     */
    @Test
    public void testGetCompetences() {
        List<Competence> expResult = null;
        List<Competence> result = instance.getCompetences();
        assertNotEquals(expResult, result);
    }
    
}
