/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import m2.textio.ITextIO;
import m2.textio.TextIOFactory;

/**
 *
 * @author Pravien
 */

public class  Bag  {
   private ArrayList<Item> playerInventory;
   ITextIO io = TextIOFactory.getSysTextIO();
    
    public Bag(){
        playerInventory = new ArrayList<>();
        
    }

    

    public void addItemToPlayerInventory(Item currentItem,Player newPlayer){
        
        if(newPlayer.getPlayerBag().getBagSize()!=6){
            newPlayer.getPlayerBag().getPlayerInventory().add(currentItem);
        }
    }
    
    public void ListPlayerInventoryItems(){
        
        if(this.playerInventory.size()>0)
        {
            for (int i = 0; i < this.playerInventory.size(); i++)
            {
                System.out.println((i+1)+".Item "+this.playerInventory.get(i).getName());
                System.out.println("  - " +this.playerInventory.get(i).getDescription());
            
            }
    
        }
        else{
            System.out.println("Du har ingen ting i din bag");
        }
    
    }

    public ArrayList<Item> getPlayerInventory()
    {
        return playerInventory;
    }
    
    
    
    public void removeInventory(int itemNumber){
        
        ArrayList<Item> TempplayerInventory = new ArrayList<>();
        for (int i = 0; i < this.playerInventory.size(); i++){
            if(i!=itemNumber-1){
                TempplayerInventory.add(playerInventory.get(i));
            }
        }
        playerInventory=TempplayerInventory;
        
    }
    
    public Item getPlayerInventoryItem(int itemNumber){
        Item temp =  new HpPotion(1);
        
        
        for (int i = 0; i < this.playerInventory.size(); i++){
            
            if(itemNumber-1==i){
                
               temp=playerInventory.get(i);
                
            }
            
        }
        
        return temp;
        
    }
    
    public void potionOrSword(Item temp,Player currentPlayer){
        
            if(temp instanceof HpPotion){
                
                HpPotion tempHP=(HpPotion) temp;
                tempHP.healPlayer(currentPlayer);
                io.put("You were healed, you HP is now " + currentPlayer.getHealth());
               
            }
             
            else if (temp instanceof Sword){
                Sword tempSword=(Sword) temp;
                Sword oldSword = currentPlayer.removeSword(tempSword);
                io.put("Your attack damage was buffed with " + tempSword.getBonusAttackDamage());
                this.addItemToPlayerInventory(oldSword, currentPlayer);
                
                
            }
    }
            
    
    public int getBagSize(){
        return playerInventory.size();
    }
            
}
