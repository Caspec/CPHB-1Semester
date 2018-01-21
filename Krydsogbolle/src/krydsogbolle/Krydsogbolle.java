/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krydsogbolle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author auron
 */
public class Krydsogbolle
{
   // ArrayList al
   private ArrayList<String> al = new ArrayList<>();
   // Scanner scan
   private Scanner scan = new Scanner(System.in);
   
   // Add A1,A2,A3,B1,B2,B3,C1,C2,C3 ArrayList al
    public void addToBoard() 
    {
        // Add til ArrayList(0,1,2) felt 1,2,3.
        al.add("A1");
        al.add("A2");
        al.add("A3");
        // Add til ArrayList(3,4,5) felt 4,5,6.
        al.add("B1");
        al.add("B2");
        al.add("B3");
        // Add til ArrayList(6,7,8) felt 7,8,9.
        al.add("C1");
        al.add("C2");
        al.add("C3");
    }
    
    //Denne metode laver en spiller (Spiller 1 og Spiller 2).
    public Player makePlayer(String XO, String type)
    {
        System.out.println(XO+": Indtast dit navn");
        String text = scan.next();
        Player newplayer = new Player(text);
        return newplayer;
    }
    
    // Viser spillebrættet
    public String showBoard() 
    {
        boolean firstTime = true;
        String res = " ";
        for (int i = 0; i < 8; i++)
        {
            // Første gang spillet vises for Spiller 1 (X)
            if(firstTime == true)
            {
                String line = "";
                System.out.print("\n");
                line = al.get(0) + " - " + al.get(1) +" - " +al.get(2);
                System.out.println(line);
                System.out.println("----------");
                line = al.get(3) + " - " + al.get(4) +" - " +al.get(5);
                System.out.println(line);
                System.out.println("----------");
                line = al.get(6) + " - " + al.get(7) +" - " +al.get(8);
                System.out.println(line);
                System.out.println();
                firstTime = false;
                break;
            }
            // Hvis al index er det samme som "x" eller "o"
            if(al.get(i).equalsIgnoreCase("x") || al.get(i).equalsIgnoreCase("o")) 
            {
                String line = "";
                System.out.print("\n");
                line = al.get(0) + " - " + al.get(1) +" - " +al.get(2);
                System.out.println(line);
                System.out.println("----------");
                line = al.get(3) + " - " + al.get(4) +" - " +al.get(5);
                System.out.println(line);
                System.out.println("----------");
                line = al.get(6) + " - " + al.get(7) +" - " +al.get(8);
                System.out.println(line);
                System.out.println();
            }
            
        
        }
        
        return res;
    }
    // Det spilleren skriver fx. A1,A2,A3 
    public String playerInput(Player playername, String type) 
    {
        String name = playername.getName();
        String type1 = type;
        System.out.println("\n"+name+" du skal placere dit " +type1+ ":\n" + showBoard());
        String input = scan.next();
        return input;
    }
    // Det som man har indskrevet bliver valideret og hvis det er sandt, så bliver det indsat på Arraylisten fra index 0-8
    public void gameLogic(String x, Player player, String type)
    {
        Boolean valid = true;
        while(valid) 
        {   
            
            String k  = playerInput(player, type);
            
            if(k.equalsIgnoreCase("A1") && !al.get(0).equalsIgnoreCase("x") && !al.get(0).equalsIgnoreCase("o"))
            {
                al.set(0, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("A2") && !al.get(1).equalsIgnoreCase("x") && !al.get(1).equalsIgnoreCase("o"))
            {
                al.set(1, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("A3") && !al.get(2).equalsIgnoreCase("x") && !al.get(2).equalsIgnoreCase("o"))
            {
                al.set(2, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("B1") && !al.get(3).equalsIgnoreCase("x") && !al.get(3).equalsIgnoreCase("o"))
            {
                al.set(3, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("B2") && !al.get(4).equalsIgnoreCase("x") && !al.get(4).equalsIgnoreCase("o"))
            {
                al.set(4, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("B3") && !al.get(5).equalsIgnoreCase("x") && !al.get(5).equalsIgnoreCase("o"))
            {
                al.set(5, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("C1") && !al.get(6).equalsIgnoreCase("x") && !al.get(6).equalsIgnoreCase("o"))
            {
                al.set(6, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("C2") && !al.get(7).equalsIgnoreCase("x") && !al.get(7).equalsIgnoreCase("o"))
            {
                al.set(7, x);
                valid = false;
            }
          else if(k.equalsIgnoreCase("C3") && !al.get(8).equalsIgnoreCase("x") && !al.get(8).equalsIgnoreCase("o"))
            {
                al.set(8, x);
                valid = false;
            }
            else 
            {
                System.out.println("\nDet er ikke et valid input du skriver!... Prøv igen");
            }

        }
        
         
    }
    // Her checker vi om man har vundet ved 3 ens på lodret,vandret eller på kryds
    public boolean isCheckXO(String XO)
    {
        boolean resultat = false;
        
        // Vandret A1,A2,A3
        if(al.get(0).equals(XO) && al.get(1).equals(XO) && al.get(2).equals(XO))
        {
           resultat = true; 
        }
        // Vandret B1,B2,B3
        else if(al.get(3).equals(XO) && al.get(4).equals(XO) && al.get(5).equals(XO))
        {
            resultat = true;
        }
        // Vandret C1,C2,C3
        else if(al.get(6).equals(XO) && al.get(7).equals(XO) && al.get(8).equals(XO))
        {
            resultat = true;
        }
        // Lodret A1,B1,C1
        else if(al.get(0).equals(XO) && al.get(3).equals(XO) && al.get(6).equals(XO))
        {
            resultat = true;
        }
        // Lodret A2,B2,C2
        else if(al.get(1).equals(XO) && al.get(4).equals(XO) && al.get(7).equals(XO))
        {
            resultat = true;
        }
        // Lodret A3,B3,C3
        else if(al.get(2).equals(XO) && al.get(5).equals(XO) && al.get(8).equals(XO))
        {
            resultat = true;
        }
        // Skrå A1,B2,C3
        else if(al.get(0).equals(XO) && al.get(4).equals(XO) && al.get(8).equals(XO))
        {
            resultat = true;
        }
        // Skrå A3,B2,C1
        else if(al.get(2).equals(XO) && al.get(4).equals(XO) && al.get(6).equals(XO))
        {
            resultat = true;
        }
        
        return resultat;
    }
    // Her checker vi om det er uafgjort hvis ingen har vundet
    public boolean isDraw()
    {
       boolean resultat = false;
       String A1 = "A1";
       String A2 = "A2";
       String A3 = "A3";
       String B1 = "B1";
       String B2 = "B2";
       String B3 = "B3";
       String C1 = "C1";
       String C2 = "C2";
       String C3 = "C3";
       
        if(!al.get(0).equals(A1) && !al.get(1).equals(A2) && !al.get(2).equals(A3) && !al.get(3).equals(B1) && !al.get(4).equals(B2) && !al.get(5).equals(B3) && !al.get(6).equals(C1) && !al.get(7).equals(C2) && !al.get(8).equals(C3))
        {
            resultat = true;
        }

        return resultat;
    }
    
    // Restart spil eller stop spillet
    public boolean isRestart(String XO)
    {
       boolean resultat = false;
       
       if(isDraw() || isCheckXO(XO))
       {
           showBoard();
           System.out.println("Vil du gerne prøve igen?");
           System.out.println("Vælg mellem 0 og 1.");
           System.out.println("0: Stop spillet");
           System.out.println("1: Start et nyt spil");
           while(true) 
           {
               String input = scan.next();
               
               if(input.equalsIgnoreCase("0"))
               {
                    // Stop spillet
                    showBoard();
                    if(isDraw() == true)
                    {
                        System.out.println("Ingen vandt...");
                    }
                    else 
                    {
                        System.out.println(XO.toUpperCase()+ " Vandt tillykke!");
                    }
                    System.exit(0);
               }
               
               else if(input.equalsIgnoreCase("1"))
               {
                    // Restart spil
                    resultat = true;
                    if(isDraw() == true)
                    {
                        System.out.println("\nIngen vandt forrige spil...\n");
                    }
                    else 
                    {
                        System.out.println("\n"+XO.toUpperCase()+ " Vandt forrige spil tillykke!");
                    }
                    al.clear();
                    runGame();
               }
               else 
               {
                    System.out.println("Du har ikke skrevet et valid input.");
               }
           }
       }
       
       return resultat;
    }
    
    // Her kører vi spillet og opretter fx spillerne og kører indholdet i Arraylist al
    public void runGame() 
    {
        addToBoard();
        Boolean gameIsRunning = true;
        Player player1 = makePlayer("Spiller 1", "X");
        Player player2 = makePlayer("Spiller 2", "O");
        String outerXO = "";
        outerloop:
        while(gameIsRunning)
        {
            if(isDraw() == true)
            {
                showBoard();
                System.out.println("Ingen vandt... Prøv igen!");
                break outerloop;
            }
            
            isRestart(outerXO);
            
            gameLogic("x", player1, "X");
            if(isCheckXO("x") == true)
            {
                String XO = "x";
                isRestart(XO);
                System.out.println("X har vundet!");
                break outerloop;
            
            }
            else 
            {
                System.out.println("\n");
            }
            
            isRestart(outerXO);
            
            if(isDraw() == true)
            {
                showBoard();
                System.out.println("Ingen vandt... Prøv igen!");
                break outerloop;
            }
        
            gameLogic("o", player2, "O");
            if(isCheckXO("o") == true)
            {
                String XO = "o";
                isRestart(XO);
                System.out.println("O har vundet!");
                break outerloop;
            }
            else 
            {
                System.out.println("\n");
            }
            
  
        }
        

    }
    
}
