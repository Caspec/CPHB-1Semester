/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggame;

import java.util.Random;
import java.util.Scanner;
import javafx.scene.input.KeyCode;

/**
 *
 * @author auron
 */
public class Piggame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
     //   System.out.print("enter input:");
     //   Scanner s = new Scanner(System.in);
     //   String input = s.nextLine();
     //   System.out.println("Hello "+input);
        
     //   int p = (int) (Math.random()*6+1);
     //   System.out.println(">>"+p);
        
     //   Random  rand = new Random();
     //  System.out.println(rand.nextInt(6)+1);
     
     // 2 terninger
     // 2 totale beløb og 2 kast resultater
    
     int sum_Dice;
     int mid = 0;
     int bank_Human = 0;
     int bank_AI = 0;
     int dice_1;
     int dice_2;
     
     Scanner scan = new Scanner(System.in);
     
     System.out.print("Welcome to pig game... Oink oink... Press Enter to start the game:");
     String enter = scan.nextLine();
     
     while(bank_Human < 100 || bank_AI < 100){
         System.out.println("BANK HUMAN : " + bank_Human);
         System.out.println("BANK AI : " + bank_AI);
         
         while(true){
             // Human player turn
            dice_1 = (int) (Math.random()*6+1);
            dice_2 = (int) (Math.random()*6+1);
            sum_Dice = dice_1 + dice_2;
            mid = mid + sum_Dice; 
            System.out.println("\t\tHuman");
            System.out.println("\t\tDice 1: " +dice_1);
            System.out.println("\t\tDice 2: " +dice_2);
            System.out.println();
            System.out.println("\t\tTotal: " +sum_Dice);
            System.out.println("Current Total: " + mid );
            

             if(dice_1 == 1 || dice_2 == 1){
                mid = 0;
                bank_Human = bank_Human + mid;
                System.out.println();
                System.out.println();
                break; 
                
            }
             
           System.out.println("Do you wanna safe your points in the Bank? Type : YES And Enter - Press enter to roll again");
           String input = scan.nextLine();
       
            if(input.equals("YES")){
               bank_Human = bank_Human + mid;
               mid = 0;
               System.out.println();
               System.out.println();
               break;

            } 
           
       } 
         
         

         while(true){
             // AI player turn
             dice_1 = (int) (Math.random()*6+1);
             dice_2 = (int) (Math.random()*6+1);
             sum_Dice = dice_1 + dice_2;
             mid = mid + sum_Dice; 
           
           if(dice_1 == 1 || dice_2 == 1){
              mid = 0;
              bank_AI = bank_AI + mid;
              break; 
                
            } 
             
           if(mid < 21){
                System.out.println("\t\tAI");
                System.out.println("\t\tDice 1: " +dice_1);
                System.out.println("\t\tDice 2: " +dice_2);
                System.out.println();
                System.out.println("\t\tTotal: " +sum_Dice);
           
        }
           else if(mid > 21)
        {
                bank_AI = bank_AI + mid;
                mid = 0;
                break; 
        }
      }
         
         
     }
     
  }
     
}
    


