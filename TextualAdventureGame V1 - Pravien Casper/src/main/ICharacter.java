/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Pravien
 */
public interface ICharacter
{
     public String getName();
    

    public void setName(String name);
    

    public int getHealth();
    

    public void setHealth(int health);
    
    public void setHasSword(Boolean hasSword);
    
    public Boolean getHasSword();
    
    public void addSword(Sword newSword);
    
    public Sword removeSword(Sword newSword);
    
    
} 
