/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author auron
 */
public class Account
{
    private int credit;
    

    public void winCredit(int bet)
    {
        credit += bet;
    }
    
    public void looseCredit(int bet)
    {
        credit -= bet;
    }
    
    public void onenhalfTimes(int bet)
    {
        
        credit +=  (int)Math.round(1.5 * bet);
    }
    
    public void twoTimes(int bet)
    {
        credit +=  (int)Math.round(2.0 * bet);
    }
    
    public void threeTimes(int bet)
    {
        credit +=  (int)Math.round(3.0 * bet);
    }

    public int getCredit()
    {
        return credit;
    }

    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
//    @Override
//    public String toString()
//    {
//        return "Credit: " + credit;
//    }
}
