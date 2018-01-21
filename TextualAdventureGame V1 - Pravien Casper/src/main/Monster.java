/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Objects;

/**
 *
 * @author Pravien
 */
public class Monster extends Fighter implements ICharacter
{
    int health=100;
    int roomID;
    String name;
    Boolean hasSword = false;
    
    Sword monsterSword;
    
    public Monster (String name,int roomID){
        this.name = name;
        this.roomID=roomID;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Monster other = (Monster) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.roomID != other.roomID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

  

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    
    public void setHasSword(Boolean hasSword){
    
             this.hasSword=hasSword;
     }
    
    public Boolean getHasSword(){
        
        return hasSword;
        
    }
    
    public void addSword(Sword newSword){
        monsterSword = newSword;
        this.setMaxAttackDamage(this.getMaxAttackDamage()+monsterSword.getBonusAttackDamage());
        
    }

    
    
    
    public Sword getSword(){
        return monsterSword;
    }
    
//    public Sword removeSword(Sword newSword,Fighter currentPlayer){
//        
//        Sword oldSword=monsterSword;
//        currentPlayer.setMaxAttackDamage(currentPlayer.getMaxAttackDamage()-this.monsterSword.getBonusAttackDamage());
//        addSword(newSword,currentPlayer);
//        return oldSword;
//    }
    public Sword removeSword(Sword newSword){
        
        Sword oldSword=monsterSword;
        this.setMaxAttackDamage(this.getMaxAttackDamage()-this.monsterSword.getBonusAttackDamage());
        addSword(newSword);
        return oldSword;
    }
    

   
    
    
   
    
    
   
    
    
    
}
