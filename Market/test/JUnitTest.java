/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
    
    private DAO d;
    private Item item;
    
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
        item = new Item(1, "sutter", "sutteso", 10.0, "img.png", 4);
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
     public void addKurv() 
     {
         vareServlet s = new vareServlet();
         s.addItem(1);
         int expectedValue = 1;
         int actualValue = s.kurv.size();
         
         
         assertEquals(expectedValue, actualValue);
     }
     
     @Test
     public void getOneItem_id() 
     {
         d.getOneItem(1);

         int expectedValue = 1;
         int actualValue = d.getOneItem(1).getItem_id();

         assertEquals(expectedValue, actualValue);
         
         
     }
     
     @Test
     public void getOneItem_name() 
     {
        d.getOneItem(14);
        String expectedValue = "Lones ex. mand lig";
        String actualValue = d.getOneItem(14).getItem_name();

         assertEquals(expectedValue, actualValue);
     }
     
     @Test
     public void getOneItem_price() 
     {
        d.getOneItem(22);
        double expectedValue = 50000.00;
        double actualValue = d.getOneItem(22).getItem_price();
        
        assertEquals(expectedValue, actualValue, 0.0001);
     }
}
