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
public interface IThinker extends IPlayer
{
    public void thinkOfANumber();
    // Returns a negative integer if number is less than the secret number
    // Returns a positive integer if number is greater than the secret number
    // Returns zero if number is equal to the secret number
    public int evaluate(int number);   
}
