/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g27;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;
/**
 *
 * @author stev
 */
public class G27 implements PlayerFactory<BattleshipsPlayer>{

 
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        return new SuperPlayer();
    }

    @Override
    public String getID()
    {
        return "G27";
    }

    @Override
    public String getName()
    {
        return "Lone fra klubben";
    }

    @Override
    public String[] getAuthors()
    {
        String[] res = {"Heroin Mesterne"};
        return res;
    }
}
