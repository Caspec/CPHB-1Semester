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
public class MonsterTest
{
    Monster newMonster;
    Sword firstSword;
    Sword secondSword;
    
    public MonsterTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @Before
    public void setUp()
    {
        newMonster = new Monster("Robert",5);
        firstSword = new Sword (1);
        secondSword = new Sword(1);
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getHealth method, of class Monster.
     */
    @Test
    public void testGetHealth()
    {
    }

    /**
     * Test of setHealth method, of class Monster.
     */
    @Test
    public void testSetHealth()
    {
    }

    /**
     * Test of getName method, of class Monster.
     */
    @Test
    public void testGetName()
    {
        
        String expectedOutPut = "Robert";
        String actualOutPut = newMonster.getName();
        assertEquals(expectedOutPut,actualOutPut);
    }

    /**
     * Test of setName method, of class Monster.
     */
    @Test
    public void testSetName()
    {
        
    }

    /**
     * Test of hashCode method, of class Monster.
     */
    @Test
    public void testHashCode()
    {
    }

    /**
     * Test of equals method, of class Monster.
     */
    @Test
    public void testEquals()
    {
    }

    /**
     * Test of getRoomID method, of class Monster.
     */
    @Test
    public void testGetRoomID()
    {
    }

    /**
     * Test of setRoomID method, of class Monster.
     */
    @Test
    public void testSetRoomID()
    {
    }

    /**
     * Test of setHasSword method, of class Monster.
     */
    @Test
    public void testSetHasSword()
    {
    }

    /**
     * Test of getHasSword method, of class Monster.
     */
    @Test
    public void testGetHasSword()
    {
    }

    /**
     * Test of addSword method, of class Monster.
     */
    @Test
    public void testAddSword()
    {
        
        
        firstSword.setBonusAttackDamage(5);
        newMonster.addSword(firstSword);
        int expectedOutPut = 15;
        int actualOutPut=newMonster.getMaxAttackDamage();
        assertEquals(expectedOutPut, actualOutPut);
    }

    /**
     * Test of getSword method, of class Monster.
     */
    @Test
    public void testGetSword()
    {
    }

    /**
     * Test of removeSword method, of class Monster.
     */
    @Test
    public void testRemoveSword()
    {
        
        
        firstSword.setBonusAttackDamage(5);
        newMonster.addSword(firstSword);
       
        
        secondSword.setBonusAttackDamage(6);
        newMonster.removeSword(secondSword);
        int expectedOutPut = 16;
        int actualOutPut = newMonster.getMaxAttackDamage();
        assertEquals(expectedOutPut, actualOutPut);
        
    }
    
}
