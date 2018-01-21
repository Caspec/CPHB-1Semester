/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.TimeUnit;
import m2.textio.ITextIO;
import m2.textio.TextIOFactory;

/**
 *
 * @author Pravien
 */
public class Combat
{

    ITextIO io = TextIOFactory.getSysTextIO();

    public void applyItemStat(Player currentPlayer, Bag playerBag, int kk)
    {
        //this method is used to apply an items stat to the player.
        playerBag.potionOrSword(playerBag.getPlayerInventoryItem(kk), currentPlayer);
        playerBag.removeInventory(kk);
    }
    
    public void ApplyMonsterOrPlayerDamage(Fighter fighter,ICharacter attacker,ICharacter attackReciver, int minDamage, int maxDamage){
        //here we generate an attackdamge number for the player
            
            
            int playerDamage = fighter.damageDealt(minDamage, maxDamage);
            io.put("------"+ attacker.getName() +" turn ------\n");
            io.put(attacker.getName() +" damaged "+ attackReciver.getName()  +" "+ playerDamage);
            //here we change the monster health depending on how much dmg the player did
            attackReciver.setHealth(attackReciver.getHealth() - playerDamage);
            // this if statement makes sure that we dont get an negativ health
            if (attackReciver.getHealth() < 0)
            {
                attackReciver.setHealth(0);
            }
            io.put(attackReciver.getName() +" current health is " + attackReciver.getHealth() + "\n");
            io.put("------ End Of tur ------\n");
            io.put("\n");
    }



    public void battle(Player currentPlayer, Monster currentMonster, Bag playerBag) throws InterruptedException
    {
        // here we get the minAttack and maxAttack damage for the player and the monster
        
        
        while (currentPlayer.getHealth() > 0 && currentMonster.getHealth() > 0)
        {
            int playerMinDamage = currentPlayer.getMinAttackDamage();
            int playerMaxDamage = currentPlayer.getMaxAttackDamage();
            int monsterMinDamage = currentMonster.getMinAttackDamage();
            int monsterMaxDamage = currentMonster.getMaxAttackDamage();
            
            // this if will run if the attack is not blocked
            
            
            
            Boolean playerTurn = true;
            if (!currentPlayer.isAttackBlocked() && playerTurn)
            {
                //applyMonsterOrPlayerDamage(playerTurn, currentMonster, monsterMinDamage, monsterMaxDamage, currentPlayer, playerMinDamage, playerMaxDamage);
                ApplyMonsterOrPlayerDamage(currentPlayer,currentPlayer,currentMonster,playerMinDamage,playerMaxDamage);
            } else
            {
                io.put("------ Player turn ------\n");
                io.put("Player missed his attack\n");
                io.put("------ End Of tur ------\n");
                io.put("\n");
            }

            TimeUnit.SECONDS.sleep(3);
            // this if will run if the attack is not blocked
            playerTurn = false;
            if (!currentMonster.isAttackBlocked() && currentMonster.getHealth()!=0)
            {
                //applyMonsterOrPlayerDamage(playerTurn, currentMonster, monsterMinDamage, monsterMaxDamage, currentPlayer, playerMinDamage, playerMaxDamage);
                ApplyMonsterOrPlayerDamage(currentMonster,currentMonster,currentPlayer,monsterMinDamage,monsterMaxDamage);
            } else
            {
                io.put("------ Monster turn ------\n");
                io.put("Monster missed his attack\n");
                io.put("------ End Of tur ------\n");
                io.put("\n");
            }

            if (currentPlayer.getHealth() != 0 && playerBag.getBagSize() != 0)
            {
                io.put("You wanna View your bag?");
                io.put("    \npress (Y) for yes");
                if (io.get().toLowerCase().equals("y"))
                {
                    io.put("\n");
                    playerBag.ListPlayerInventoryItems();
                    io.put("\n");
                    io.put("\nChoose an item buy pressing the number of the item");
                    io.put(" Else if you wanna leave the back press 0");

                    
                    int kk = io.getInteger(0, 6);

                    useBagInventory(currentPlayer, playerBag, kk);
                }
            }

        }

        io.put("player health " + currentPlayer.getHealth() + " And Monster health is " + currentMonster.getHealth());
    }

    public void useBagInventory(Player currentPlayer, Bag playerBag, int kk)
    {
        if (playerBag.getBagSize() == 1 && kk == 1)
        {

            applyItemStat(currentPlayer, playerBag, kk);

        } else if (playerBag.getBagSize() == 2 && (kk == 1 || kk == 2))
        {

            applyItemStat(currentPlayer, playerBag, kk);

        } else if (playerBag.getBagSize() == 3 && (kk == 1 || kk == 2 || kk == 3))
        {

            applyItemStat(currentPlayer, playerBag, kk);

        } else if (playerBag.getBagSize() == 4 && kk > 0 && kk < 5)
        {

            applyItemStat(currentPlayer, playerBag, kk);

        } else if (playerBag.getBagSize() == 5 && kk > 0 && kk < 6)
        {
            applyItemStat(currentPlayer, playerBag, kk);
        } else if (playerBag.getBagSize() == 6 && kk > 0 && kk < 7)
        {
            applyItemStat(currentPlayer, playerBag, kk);
        } else
        {
            io.put("You left the menu\n");
        }

    }

}
