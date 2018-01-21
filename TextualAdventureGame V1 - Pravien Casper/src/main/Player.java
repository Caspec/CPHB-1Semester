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
public class Player extends Fighter implements ICharacter
{

    private String name;
    private int health;
    private int gold;
    private Boolean hasSword = false;
    private Sword playerSword;
    private Bag playerBag;

    public Player(String name)
    {
        this.name = name;
        setHealth(100);
        setGold(100);
        playerBag=new Bag();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold += gold;
    }
    
    public void setHasSword(Boolean hasSword){
    
             this.hasSword=hasSword;
     }
    
    public Boolean getHasSword(){
        
        return hasSword;
        
    }
    // this method adds a new swod to the player.
    public void addSword(Sword newSword){
        playerSword = newSword;
        this.setMaxAttackDamage(this.getMaxAttackDamage()+playerSword.getBonusAttackDamage());
        
    }

    public Bag getPlayerBag()
    {
        return playerBag;
    }
    
    
    public Sword getSword(){
        return playerSword;
    }
    
   // this method remove the sword that the player have.
    @Override
    public Sword removeSword(Sword newSword){
        Sword oldSword= this.getSword();
        // we remove the bonus damage.
        this.setMaxAttackDamage(this.getMaxAttackDamage()-oldSword.getBonusAttackDamage());
        addSword(newSword);
        return oldSword;
    }  

   

    
}
