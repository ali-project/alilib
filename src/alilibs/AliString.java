/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

/**
 *
 * @author a
 */
public class AliString {
    public static int StringToInter(String str)
    {
            
        return new Integer(str.split("\\.")[0]);
        
    }
}
