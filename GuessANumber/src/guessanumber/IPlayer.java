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
public interface IPlayer
{
    public void startGame(int min, int max);
    public void endGame(int numberOfGuesses);
}
