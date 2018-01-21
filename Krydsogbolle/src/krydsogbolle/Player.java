/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krydsogbolle;

/**
 *
 * @author auron
 */
public class Player
{
    private String name;
    
    public Player(String name)
    {
        this.name = name;
    }

    Player()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
