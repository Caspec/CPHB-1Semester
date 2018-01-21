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
public class Fighter  {
    
    
   private int minAttackDamage=5;
   private int MaxAttackDamage=10;
   private Boolean hasSword = false;

    public Boolean getHasSword()
    {
        return hasSword;
    }

    public void setHasSword(Boolean hasSword)
    {
        this.hasSword = hasSword;
    }
   
   
   

    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    public void setMinAttackDamage(int minAttackDamage) {
        this.minAttackDamage = minAttackDamage;
    }

    public int getMaxAttackDamage() {
        return MaxAttackDamage;
    }

    public void setMaxAttackDamage(int MaxAttackDamage) {
        this.MaxAttackDamage = MaxAttackDamage;
    }
    
    public Boolean isAttackBlocked (){
        
        int k = (int) Math.floor((Math.random() * 8) + 0);
        if(k==5){
            return true;
        }
        return false;
    }
    
    // This method determins the damageDealt.
    public int damageDealt(int minAttackDamage,int MaxAttackDamage){
        
        // we decide a attack range.
         int range = (MaxAttackDamage - minAttackDamage) + 1;
        return (int) Math.floor((Math.random() * range) + minAttackDamage);
    }
    
    
}
