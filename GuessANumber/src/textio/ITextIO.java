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
public interface ITextIO extends ISimpleTextIO
{
    public int getInteger(int min, int max);
    public int select(String header, Iterable<String> choices, String footer);
    public int select(String header, String[] choices, String footer);
}
