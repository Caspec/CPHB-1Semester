/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author auron
 */
public class JUnitTest
{
    private double height;
    private double length;
    private int price;
    private int glassPrice = 300;
    private DAO d;
    
    public JUnitTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        d = new DAO();
    }
    
    @After
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testThousand()
    {
        PriceCalc c = new PriceCalc(100.00,160.00, 100);
        
        double expectedValue = 1000.0;
        double actualValue = c.totalPrice();
        
        assertEquals(expectedValue, actualValue, 0.0001);
    }
    
    @Test
    public void testMegaNumber()
    {
        PriceCalc c = new PriceCalc(100000.00,1600000.00, 10000);
        
        double expectedValue = 16000000100.00;
        double actualValue = c.totalPrice();
        
        assertNotEquals(expectedValue, actualValue, 0.0001);
    }
    
    @Test
    public void testZeroNumber()
    {
        PriceCalc c = new PriceCalc(0.0,0.0, 0);
        
        double expectedValue = 0;
        double actualValue = c.totalPrice();
        
        assertEquals(expectedValue, actualValue, 0.0001);
    }
    
    @Test
    public void testMinZeroNumber()
    {
        PriceCalc c = new PriceCalc(-0.0,-0.0, -0);
        
        double expectedValue = -0;
        double actualValue = c.totalPrice();
        
        assertEquals(expectedValue, actualValue, 0.0001);
    }
}
