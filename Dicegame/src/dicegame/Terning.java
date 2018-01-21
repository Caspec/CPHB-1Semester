/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.Random;

/**
 *
 * @author auron
 */
public class Terning {
    
     private int tal;
        
    public int kast()
    {
        Random r = new Random();
        tal = r.nextInt(6)+1;

        return tal;
    }
    
 
    
}
    

