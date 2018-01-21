/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textio;

/**
 *
 * @author Tobias Grundtvig
 */
public class TextIOFactory
{
    private static ITextIO sysIO = null;
    
    public static ITextIO getSysTextIO()
    {
        if(sysIO == null)
        {
            sysIO = new TextIO(new SysTextIO());
        }
        return sysIO;
    }
    
    public static ITextIO newGUITextIO()
    {
        return new TextIO(GUITextIO.createGUI());
    }
}
