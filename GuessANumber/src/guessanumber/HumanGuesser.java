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
public class HumanGuesser implements IGuesser
{
    private final ITextIO io;
    private int min;
    private int max;

    public HumanGuesser(ITextIO io)
    {
        this.io = io;
    }

    @Override
    public int makeGuess()
    {
        io.put("Please make your guess: ");
        int guess = io.getInteger(min, max);
        return guess;
    }

    @Override
    public void feedback(int feedback)
    {
        io.put("\nYour guess was ");
        if(feedback < 0)
        {
            io.put("too low");
        }
        else if(feedback > 0)
        {
            io.put("too high");
        }
        else
        {
            io.put("correct");
        }
        io.put("!\n");
    }

    @Override
    public void startGame(int min, int max)
    {
        this.min = min;
        this.max = max;
        io.put("New game started in the range from " + min + " to " + max + " (both inclusive).\n");
    }

    @Override
    public void endGame(int numberOfGuesses)
    {
        io.put("\nGame over, you used " + numberOfGuesses + " number of guesses!\n");
        io.put("Press ENTER to quit...");
        io.get();
        io.clear();
    }
    
}
    
