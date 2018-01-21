/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author auron
 */
public class Test
{
    public static void main(String[] args)
    {
        // Test på metoden applyMonsterOrPlayerDamage
        System.out.println("Test på applyMonsterOrPlayerDamage\n");
        Combat combat = new Combat();
        combat.applyMonsterOrPlayerDamage(true, new Monster("", 1), 0, 0, new Player(""), 0, 0);
        System.out.println();
        
        
        // Test på Get og Set af Players health
        Player p = new Player("");
        System.out.println("Get første gang "+p.getHealth());
        System.out.println("Sæt til 50");
        p.setHealth(50);
        System.out.println("Get anden gang "+p.getHealth());
        
        
        
    }
    
    
}
