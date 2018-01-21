/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessanumber;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import textio.ITextIO;

/**
 *
 * @author Tobias Grundtvig
 */
public class HumanThinker implements IThinker
{
    private final ITextIO io;
    private final String[] evalStr = { "Too low", "Correct", "Too high" };

    public HumanThinker(ITextIO io)
    {
        this.io = io;
    }
    
    @Override
    public void thinkOfANumber()
    {
        io.put("Please think of a secret number. Press ENTER when ready.");
        io.get();
        io.clear();
    }

    @Override
    public int evaluate(int number)
    {
        io.clear();
        int r = io.select("The guesser have guessed on " + number + ". Is it", evalStr, "Please select your evaluation:");
        return r - 1;
    }

    @Override
    public void startGame(int min, int max)
    {
        io.put("New game started in the range from " + min + " to " + max + " (both inclusive).\n");
    }

    @Override
    public void endGame(int numberOfGuesses)
    {
        io.put("\nGame over, the guesser used " + numberOfGuesses + " number of guesses!\n");
        io.put("Press ENTER to quit...");
        io.get();
        io.clear();
    }
    
}
