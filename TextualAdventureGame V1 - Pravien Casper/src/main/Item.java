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
public interface Item {
   

   public int getRoomID() ;
        
    

   public void setRoomID(int roomID);

   public String getName(); 
        
    

   public void setName(String name); 
        
    

   public String getDescription() ;
       
    

  public  void setDescription(String description) ;
        
    
   @Override
   public String toString();
   
   public int getItemID();
    

    public void setItemID(int itemID);
    
    
}
