/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author That One Guy
 */
public class SurveyTest {
    
    public SurveyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setTitle method, of class Survey.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String initTitle = "";
        Survey instance = new Survey();
        instance.setTitle(initTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Survey.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Survey instance = new Survey();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRespondentId method, of class Survey.
     */
    @Test
    public void testGenerateRespondentId() {
        System.out.println("generateRespondentId");
        Survey instance = new Survey();
        int expResult = 1;
        int result = instance.generateRespondentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRespondentId method, of class Survey.
     */
    @Test
    public void testGetRespondentId() {
        System.out.println("getRespondentId");
        Survey instance = new Survey();
        int expResult = 0;
        int result = instance.getRespondentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySurveyResults method, of class Survey.
     */
    @Test
    public void testDisplaySurveyResults() {
        System.out.println("displaySurveyResults");
        Survey instance = new Survey();
        instance.displaySurveyResults();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logResponse method, of class Survey.
     */
    @Test
    public void testLogResponse() {
        System.out.println("logResponse");
        int respID = 1;
        int qNum = 0;
        int response = 0;
        Survey instance = new Survey();
        instance.logResponse(respID, qNum, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayQuestionStats method, of class Survey.
     */
    @Test
    public void testDisplayQuestionStats() {
        System.out.println("displayQuestionStats");
        int questNum = 0;
        Survey instance = new Survey();
        instance.displayQuestionStats(questNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterQuestions method, of class Survey.
     */
    @Test
    public void testEnterQuestions() {
        System.out.println("enterQuestions");
        Survey instance = new Survey();
        instance.enterQuestions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
