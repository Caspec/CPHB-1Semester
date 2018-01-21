/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessanumber;

/**
 *
 * @author Tobias Grundtvig
 */
public class ComputerGuesser implements IGuesser
{
    private int min;
    private int max;
    private int guess;

    @Override
    public int makeGuess()
    {
        guess = (min + max) / 2;
        return guess;
    }

    @Override
    public void feedback(int feedback)
    {
        if(feedback < 0)
        {
            min = guess + 1;
        }
        else if(feedback > 0)
        {
            max = guess - 1;
        }
    }

    @Override
    public void startGame(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public void endGame(int numberOfGuesses)
    {
        
    }
}
