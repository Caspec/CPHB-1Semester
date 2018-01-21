/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2.textio;

import java.io.Closeable;

/**
 *
 * @author Tobias Grundtvig
 */
public interface ISimpleTextIO extends Closeable
{
    public void put(String s);
    public void clear();
    public String get();
}
