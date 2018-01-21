/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pravien
 */
public class BagTest
{
    HpPotion hp1;
    HpPotion hp2;
    Bag newBag;
    public BagTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @Before
    public void setUp()
    {
        hp1 = new HpPotion(1);
       
        hp2 = new HpPotion(2);
        newBag = new Bag();
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of addItemToPlayerInventory method, of class Bag.
     */
    @Test
    public void testAddItemToPlayerInventory()
    {
    }

    /**
     * Test of ListPlayerInventoryItems method, of class Bag.
     */
    @Test
    public void testListPlayerInventoryItems()
    {
    }

    /**
     * Test of getPlayerInventory method, of class Bag.
     */
    @Test
    public void testGetPlayerInventory()
    {
    }

    /**
     * Test of removeInventory method, of class Bag.
     */
    @Test
    public void testRemoveInventory()
    {
    }

    /**
     * Test of getPlayerInventoryItem method, of class Bag.
     */
    @Test
    public void testGetPlayerInventoryItem()
    {
        newBag.getPlayerInventory().add(hp1);
        newBag.getPlayerInventory().add(hp2);
      int  expected = 1;
      int actual = newBag.getPlayerInventoryItem(1).getRoomID();
      
        assertEquals(expected, actual);
    }

    /**
     * Test of potionOrSword method, of class Bag.
     */
    @Test
    public void testPotionOrSword()
    {
    }

    /**
     * Test of getBagSize method, of class Bag.
     */
    @Test
    public void testGetBagSize()
    {
    }
    
}
