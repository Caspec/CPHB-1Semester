/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessanumber;

import java.util.Random;

/**
 *
 * @author Tobias Grundtvig
 */
public class ComputerThinker implements IThinker
{
    private Random rnd;
    private int secretNumber;
    private int min;
    private int max;

    public ComputerThinker()
    {
        rnd = new Random();
    }
   
    
    @Override
    public void thinkOfANumber()
    {
        secretNumber = min + rnd.nextInt(max - min + 1);
    }

    @Override
    public int evaluate(int number)
    {
        return number - secretNumber;
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
