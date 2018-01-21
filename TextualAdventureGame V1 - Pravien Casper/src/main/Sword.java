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
public class Sword implements Item
        
        
{
   private String name,description;
   private int roomID,itemID; 
   private int  bonusAttackDamage;
   
 
   public Sword (int roomID){
       this.roomID=roomID;
       setName("Sword");
       setItemID(2);
       setBonusAttackDamage(generateBonusAttackStat());
       description = "This Sword will buff your damage by "+getBonusAttackDamage()+" AttackDamage";
   }

    public int getBonusAttackDamage()
    {
        return bonusAttackDamage;
    }

    public void setBonusAttackDamage(int bonusAttackDamage)
    {
        this.bonusAttackDamage = bonusAttackDamage;
    }
   
   
   public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int generateBonusAttackStat() {
        return (int) Math.floor((Math.random() * 8) + 1);
    }

    @Override
     public int getItemID()
    {
        return itemID;
    }
     
    @Override 
    public void setItemID(int itemID)
    {
        this.itemID = itemID;
    }

    @Override
    public String toString()
    {
        return name + ", " + description ;
    }
    
}
