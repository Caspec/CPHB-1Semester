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
public class HpPotion implements Item {
    
   private int healStat,itemID;
   private String name,description;
   private int roomID; 
    public HpPotion (int roomID){
        this.roomID = roomID;
        name="HealthPotion";
        setItemID(1);
        
        setHealStat(generateHealstat());
        description = "This Heal potion will heal you "+getHealStat()+" HP";
        
        
    }

    public HpPotion()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
    public int getRoomID() {
        return roomID;
    }

    @Override
    public String toString()
    {
        return name + ", " + description ;
    }

    public int getItemID()
    {
        return itemID;
    }

    public void setItemID(int itemID)
    {
        this.itemID = itemID;
    }
    
    

    
    @Override
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getHealStat() {
        return healStat;
    }

    public void setHealStat(int healStat) {
        this.healStat = healStat;
    }
    
    public int generateHealstat() {
        return (int) Math.floor((Math.random() * 50) + 5);
    }
   @Override
    public String getName() {
        return name;
    }

   @Override
    public void setName(String name) {
        this.name = name;
    }

   @Override
    public String getDescription() {
        return description;
    }

   @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public void healPlayer(Player newPlayer){
       int newHealth = newPlayer.getHealth()+getHealStat();
       if(newHealth>100){
           newPlayer.setHealth(100);
           
       }
       else {
           newPlayer.setHealth(newHealth);
       }
        
    }
        
}
