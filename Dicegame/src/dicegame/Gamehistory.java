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
public class Gamehistory
{
    
    private int tur;
    private int d1;
    private int d2;
    private int g1;
    private int g2;
    private int bet;
    private int award;
    
    public Gamehistory(int tur, int d1, int d2, int g1, int g2, int bet, int award) {
        
        this.tur = tur;
        this.d1 = d1;
        this.d2 = d2;
        this.g1 = g1;
        this.g2 = g2;
        this.bet = bet;
        this.award = award;
        
    }
    
     public int tur() {
        return tur;
    }

      public int d1() {
        return d1;
    }
      
      public int d2() {
        return d2;
    }
      public int g1() {
        return g1;
    }
      public int g2() {
        return g2;
    }
      public int bet() {
        return bet;
    }
      public int award() {
        return award;
    }
    
}
