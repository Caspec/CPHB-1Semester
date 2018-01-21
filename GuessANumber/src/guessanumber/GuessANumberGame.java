/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessanumber;

import java.io.IOException;
import textio.ITextIO;
import textio.TextIOFactory;

/**
 *
 * @author Tobias Grundtvig
 */
public class GuessANumberGame
{

    public static void main(String[] args) throws IOException
    {
        GuessANumberGame game = new GuessANumberGame();
        game.run();
    }
    
    /**
     *
     * @throws IOException
     */
    public void run() throws IOException
    {
        try (ITextIO sysIO = TextIOFactory.getSysTextIO())
        {
            String[] types = { "Human", "Computer" };
            sysIO.put("Welcome to the guess a number game.\n");
            boolean sanityCheck;
            int min;
            int max;
            do
            {
                sysIO.put("Enter min value: ");
                min = sysIO.getInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
                sysIO.put("\nEnter max value: ");
                max = sysIO.getInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
                if(max < min)
                {
                    sanityCheck = false;
                    sysIO.put("\nMin must be less than or equal to max.\n");
                }
                else
                {
                    sanityCheck = true;
                }
            } while(!sanityCheck);
            sysIO.clear();
            int thinkerType = sysIO.select("What type of player is the thinker?", types, "Choose thinker type: ");
            IThinker thinker = thinkerType == 0 ? getHumanThinker() : getComputerThinker();
            sysIO.clear();
            int guesserType = sysIO.select("What type of player is the guesser?", types, "Choose guesser type: ");
            IGuesser guesser = guesserType == 0 ? getHumanGuesser() : getComputerGuesser();
            Ctrl ctrl = new Ctrl(thinker, guesser, sysIO);
            ctrl.runGame(min, max);
        }
    }
    
    private IThinker getHumanThinker()
    {
        return new HumanThinker(TextIOFactory.newGUITextIO());
    }
    
    private IThinker getComputerThinker()
    {
        return new ComputerThinker();
    }
    
    private IGuesser getHumanGuesser()
    {
        return new HumanGuesser(TextIOFactory.newGUITextIO());
    }
    
    private IGuesser getComputerGuesser()
    {
        return new ComputerGuesser();
    }
    
}
