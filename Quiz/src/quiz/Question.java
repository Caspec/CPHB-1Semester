/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.ArrayList;

/**
 *
 * @author auron
 */
public class Question
{

    private int qNumber;
    private int credit = 0;
    private String question;
    private String optionA, optionB, optionC, optionD;
    private String answer;

    // Vores constructer
    public Question(int qNumber, int credit, String question, String optionA, String optionB, String optionC, String optionD, String answer)
    {
        this.qNumber = qNumber;
        this.credit = credit;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }

    // Om det er det rigtige svar man har givet. Enten bliver den sand eller falsk
    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    // Så vi kan udskrive fra vores instance af Question istedet for det bliver noget xxxasd122312@instance
    @Override
    public String toString()
    {
        return "\nSpørgsmål " + qNumber + ": " + question + "?\n" + "\n" + optionA + "\n" + optionB + "\n" + optionC + "\n" + optionD;
    }

    public int getCredit()
    {
        return credit;
    }

    public void setCredit(int credit)
    {
        this.credit += credit;
    }

    public int looseCredit()
    {
        int credit = getCredit();
        credit -= credit;
        return credit;
    }

}
