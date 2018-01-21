package quiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author auron
 */
public class Quiz
{

    // Scanner scan
    private Scanner scan = new Scanner(System.in);
    // ArrayList al
    private ArrayList<Question> al = new ArrayList();

    // Adder til ArrayList med spørgsmål
    public void addQuestion(Question que)
    {
        al.add(que);
    }

    // Checker brugerens input og om det er det endelige svar
    public boolean checkInput(Question question)
    {
        boolean isRunning = true;
        boolean resultat = false;
        String guess;

        outerloop:
        while (isRunning)
        {
            guess = scan.next();
            // Hvis det er a,b,c eller d
            if (guess.equalsIgnoreCase("a") || guess.equalsIgnoreCase("b") || guess.equalsIgnoreCase("c") || guess.equalsIgnoreCase("d"))
            {
                System.out.println("Er du sikker på det er det du vil svare?. Indtast JA/NEJ");
                String input = scan.next();
                // Hvis man siger JA til at det er ens endelige svar
                if (input.equalsIgnoreCase("ja"))
                {
                    // Hvis gættet og svaret ER det samme
                    if (isCorrect(guess, question))
                    {
                        isRunning = false;
                        resultat = true;

                    } 
                    // Hvis gættet og svaret IKKE er det samme
                    else if (!isCorrect(guess, question))
                    {
                        System.out.println("\nDesværre det var ikke rigtige, du tabte! og fik " + question.looseCredit() + " kr.\n");
                        isRestart();

                    }

                }
                // Hvis man siger NEJ til at det er ens endelige svar
                else if (input.equalsIgnoreCase("nej"))
                {
                    // Den spørger om et nyt svar hvis man trykker NEJ
                    System.out.println("\n");
                    System.out.println("Indtast dit nye svar");
                    resultat = false;

                }

            }
            else
            {
                System.out.println("Du skal skrive enten a,b,c eller d TAK!");
            }

        }

        return resultat;

    }
    
    // Generere Spørgsmålene
    public void generateQuestions()
    {
       Question que1 = new Question(1, 1000, "Hvem var Poul Nyrup", "a: Formand for Socialdemokratiet", "b: Formand for Venstre", "c: Formand for Radikale Venstre", "d: Løsgænger", "a");
        addQuestion(que1);
        que1 = new Question(2, 2000, "Hvad får man når man bestiller en Karl Stegger ved en pølsevogn", "a: En Kraser", "b: En Medister", "c: En Ristepølse", "d: En Rødpølse", "b");
        addQuestion(que1);
        que1 = new Question(3, 4000, "Hvad betyder ordspillet: At give engang håndmadder", "a: Smørebrød", "b: Langgangsbrød", "c: At uddele øretæver", "d: At være forelsket", "c");
        addQuestion(que1);
        que1 = new Question(4, 5000, "Hvad hedder den nuværende statsminister", "a: Helle Thorning", "b: Ulla Ternes", "c: Lars Løkke", "d: Anders Samuelsen", "c");
        addQuestion(que1);
        que1 = new Question(5, 8000, "Hvem vandt EM i fodbold i 1992", "a: Tyskland", "b: Danmark", "c: Sverige", "d: England", "b");
        addQuestion(que1);
    }
    
    // Generere Selve Quizzen
    public void quiz()
    {
        generateQuestions();
        Player player = makePlayer();
        String playername = player.getName();
        int k = 3;
        
        for (int i = 0; i < al.size(); i++)
        {

            System.out.println(al.get(i));
            
            if(isHelp(k,i) == true)
            {
                k--;
                
            }
            
            if (checkInput(al.get(i)))
            {
                System.out.println("\n"+playername+" du gættede rigtigt!! Videre til næste spørgsmål");
                System.out.println(playername+" du vandt: " + al.get(i).getCredit() + " kr.");
            } 
            else
            {
                System.out.println(al.get(i));
            }

        }
        
        isRestart();

    }

    // Køre spillet
    public void runGame()
    {
        quiz();
    }
    
    // Get ArrayList af Question
    public ArrayList<Question> getAl(int i)
    {
        return al;
    }
    
    // Set ArrayList af Question
    public void setAl(ArrayList<Question> al)
    {
        this.al = al;
    }

    // Spørger om gættet og svaret er det samme
    public boolean isCorrect(String guess, Question correct)
    {

        if (guess.equalsIgnoreCase(correct.getAnswer()))
        {
            return true;
        }
        return false;
    }
    
    // Restart spil eller stop spillet
    public boolean isRestart()
    {
       boolean resultat = false;
       
           
           System.out.println("Vil du gerne prøve igen?");
           System.out.println("Vælg mellem 0 og 1.");
           System.out.println("0: Stop spillet");
           System.out.println("1: Start et nyt spil");
           outerloop:
           while(true) 
           {
               String input = scan.next();
               
               if(input.equalsIgnoreCase("0"))
               {
                    // Stop spillet
                    System.out.println("\nTak for spillet. Held og lykke næste gang!");
                    System.exit(0);
               }
               else if(input.equalsIgnoreCase("1"))
               {
                    // Restart spil
                    resultat = true;
                    System.out.println("\nOk.. Vi starter forfra og held og lykke!");
                    runGame();
               }
               else 
               {
                    System.out.println("Du har ikke skrevet et valid input.");
                    break outerloop;
               }
              
           }
           return resultat;
    }
    
    //Denne metode laver en spiller (Spiller 1 og Spiller 2).
    public Player makePlayer()
    {
        System.out.println("Indtast dit navn for at starte spillet.");
        String text = scan.next();
        Player newplayer = new Player(text);
        return newplayer;
    }
    
    // Hjælp til spilleren
    public boolean isHelp(int i, int spørgsmålnr)
    {
        boolean resultat = false;
        System.out.println("\nVil du gerne have hjælp?");
        System.out.println("Tryk JA eller NEJ");
        String input = scan.next();
        outerloop:
            while(true)
            {
                if(input.equalsIgnoreCase("ja"))
                {
                    if(i != 0)
                    {
                        resultat = true;
                        System.out.println("Du har "+ i +" hjælpemidler i alt tilbage.");
                        System.out.println("Svaret på spørgsmålet er: " +al.get(spørgsmålnr).getAnswer());
                        break;
                    }
                    else 
                    {
                        System.out.println("\nDu har desværre brugt alle dine 3 hjælpemidler...");
                        System.out.println("Skriv dit svar på spørgsmålet");
                        resultat = false;
                        return resultat;
                    }
                }
                else if(input.equalsIgnoreCase("nej"))
                {
                    System.out.println("\nSkriv dit svar på spørgsmålet");
                    resultat = false;
                    return resultat;
                }
                else
                {
                    System.out.println("Du skal skrive enten ja eller nej til om du vil have hjælp.");
                    break outerloop;
                }
            }

        return resultat;
    }

}
