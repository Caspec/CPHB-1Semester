/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessanumber;

import textio.ITextIO;

/**
 *
 * @author Tobias Grundtvig
 */
public class Ctrl
{
    private final IThinker thinker;
    private final IGuesser guesser;
    private final ITextIO io;

    public Ctrl(IThinker thinker, IGuesser guesser, ITextIO io)
    {
        this.thinker = thinker;
        this.guesser = guesser;
        this.io = io;
    }
    
    public void runGame(int min, int max)
    {
        io.put("New game started in the range: [" + min + ", " + max + "].\n");
        thinker.startGame(min, max);
        guesser.startGame(min, max);
        int numberOfGuesses = 0;
        thinker.thinkOfANumber();
        int evaluation;
        do
        {
            ++numberOfGuesses;
            int guess = guesser.makeGuess();
            io.put("Guess " + numberOfGuesses + ": " + guess);
            evaluation = thinker.evaluate(guess);
            io.put(" (" + evaluationAsString(evaluation) + ")\n");
            guesser.feedback(evaluation);
        } while(evaluation != 0);
        thinker.endGame(numberOfGuesses);
        guesser.endGame(numberOfGuesses);
        io.put("Game finished! " + numberOfGuesses + " number of guesses used!");
    }
    
    private String evaluationAsString(int evaluation)
    {
        if(evaluation < 0)
        {
            return "Too low";
        }
        if(evaluation > 0)
        {
            return "Too high";
        }
        return "Correct";
    }
}
