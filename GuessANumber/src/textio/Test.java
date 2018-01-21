/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobias Grundtvig
 */
public class Test
{
    public static void main(String[] args)
    {
        //ISimpleTextIO io = new SysTextIO();
        //greet(io);
        ISimpleTextIO io = GUITextIO.createGUI();
        greet(io);
    }
    
    private static void greet(ISimpleTextIO io)
    {
        io.put("What is your name?");
        String name = io.get();
        io.put("\nHello " + name + ", welcome to the world!\n");
        io.get();
        try
        {
            io.close();
        }
        catch(IOException ex)
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
