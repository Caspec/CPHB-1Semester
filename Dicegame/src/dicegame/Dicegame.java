/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.input.KeyCode;

/**
 *
 * @author auron
 */
public class Dicegame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /*

        While loop rundt om efter et gæt så spillet kan fortsætte...
        Hvis spilleren ikke er interesseret i en ny tur. Så skal spillet slutte og der skal vises Game History og Game Statistics.

        ########################################################

        Betting: Spilleren starter med 100 points. Man får summen at vide før man better også skal man indsætte sit bet.
        Hvis gættet er forkert så taber man det, man har satset.

        Hvis gættet er rigtigt så vinder man på baggrund af det summen består af.
        Hvis summen indeholder: 2, 3, 11 eller 12 så får man x 1.5 igen af sit bet.
        Hvis summen indeholder: 4, 5, 9 eller 10 så får man x 2.0 igen af sit bet.
        Hvis summen indeholder: 6, 7, 8 så får man x 3.0 igen af sit bet.


         */

        int sum = 0;
        int d1;
        int d2;
        int i = 1;
        int award = 0;
        Scanner scan = new Scanner(System.in);
        Terning dice = new Terning();
        Account account = new Account();
        ArrayList<Gamehistory> al = new ArrayList();

        account.setCredit(100);

        d1 = dice.kast();
        d2 = dice.kast();
        sum = d1 + d2;
        System.out.println("Terning1: " + d1);
        System.out.println("Terning2: " + d2);

        while (true)
        {

            System.out.println("Nuværende credit: " + account.getCredit());
            System.out.println("Samlede sum: " + sum);

            System.out.println("Indsæt dit bet.");

            String input_bet = scan.nextLine();
            int bet = Integer.parseInt(input_bet);

            if (bet <= account.getCredit())
            {
                // Hvis Bet er Mindre eller = Credit, køre videre i koden

                System.out.println("Gæt værdierne pr. terning for den samlede sum.");
                String input_1 = scan.nextLine();
                String input_2 = scan.nextLine();

                int x = Integer.parseInt(input_1);
                int x2 = Integer.parseInt(input_2);
                Gamehistory gh = new Gamehistory(i, d1, d2, x, x2, bet, award);

                if ((x == d1 || x == d2) && (x2 == d1 || x2 == d2))
                {
                    // hvis Gæt er Rigtigt , kør kode

                    if (sum == 2 || sum == 3 || sum == 11 || sum == 12)
                    {
                        account.onenhalfTimes(bet);
                        award = (int) Math.round(1.5 * bet);
                    }
                    if (sum == 4 || sum == 5 || sum == 9 || sum == 10)
                    {
                        account.twoTimes(bet);
                        award = (int) Math.round(2.0 * bet);
                    }
                    if (sum == 6 || sum == 7 || sum == 8)
                    {
                        account.threeTimes(bet);
                        award = (int) Math.round(3.0 * bet);
                    }

                    System.out.println("Ja... du har ret");
                    System.out.println("Nuværende credit: " + account.getCredit());
                    System.out.println("Vil du have en ny tur? Tryk: JA eller tryk Anykey"); 
                    
                    String input_svar = scan.nextLine();
                    if (input_svar.equals("JA"))
                    {
                        al.add(gh);
                        i++;   
                        
                        d1 = dice.kast();
                        d2 = dice.kast();
                        sum = d1 + d2;

                        System.out.println("Terning1: " + d1);
                        System.out.println("Terning2: " + d2);
                    } 
                    else
                    {
                        // Udskriv historik og statistik på spillet.
                        System.out.println("Spillet er slut.");
                        
                        al.add(gh);
                        i++;
                        for (Gamehistory history : al)
                        {
                            System.out.println("Tur: " + history.tur() + "\n" + "Terning 1 var: " + history.d1() + "\n" + "Terning 2 var: " + history.d2() + "\n" + "Gæt 1 var: " + history.g1() + "\n" + "Gæt 2 var: " + history.g2()+ "\n" + "Dit Bet: " + history.bet() + "\n" + "Din Gevinst: " + history.award() + "\n\n");
                        }
                        break;
                    }
                } 
                else
                {
                    account.looseCredit(bet);
                    System.out.println("Nuværende credit: " + account.getCredit());
                    System.out.println("Nej... du er en taber!");

                    if (account.getCredit() == 0)
                    {
                        System.out.println("Spillet er slut fordi du ikke har flere credits på kontoen... tak for spillet taber!");
                        al.add(gh);
                        i++;
                        
                        for (Gamehistory history : al)
                        {
                            System.out.println("Tur: " + history.tur() + "\n" + "Terning 1 var: " + history.d1() + "\n" + "Terning 2 var: " + history.d2() + "\n" + "Gæt 1 var: " + history.g1() + "\n" + "Gæt 2 var: " + history.g2()+ "\n" + "Dit Bet: " + history.bet() + "\n" + "Din Gevinst: " + history.award() + "\n\n");
                        }

                        break;
                    }

                    if (account.getCredit() > 0)
                    {
                        System.out.println("Vil du prøve igen taber? Tryk: JA");
                        String input_svar = scan.nextLine();

                        if (input_svar.equals("JA"))
                        {
                            al.add(gh);
                            i++;
                            
                            d1 = dice.kast();
                            d2 = dice.kast();
                            sum = d1 + d2;

                            System.out.println("Terning1: " + d1);
                            System.out.println("Terning2: " + d2);
                        } 
                        else
                        {
                            // Udskriv historik og statistik på spillet.
                            System.out.println("Spillet er slut.");
                            
                            for (Gamehistory history : al)
                        {
                            System.out.println("Tur: " + history.tur() + "\n" + "Terning 1 var: " + history.d1() + "\n" + "Terning 2 var: " + history.d2() + "\n" + "Gæt 1 var: " + history.g1() + "\n" + "Gæt 2 var: " + history.g2()+ "\n" + "Dit Bet: " + history.bet() + "\n" + "Din Gevinst: " + history.award() + "\n\n");
                        }
                            
                            break;
                        }
                    }

                }
                
                
                
            } 
            else
            {
                System.out.println("Du har bettet mere end din Creditline, bet igen!");
            }
        }
    }

}
