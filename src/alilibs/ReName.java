/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.io.File;

/**
 *
 * @author a
 */
public class ReName {
    
    
    public static void main(String argString[])
    {
        
        run("/Users/a/Desktop/三国演义", "52wy.480p.三国演义.dvdrip.ep","");
        
        
        
        
    }
    
    
    public static void run(String url,String will,String to)
    {
        File f = new File(url);
        File []fs = f.listFiles();
        
        
        
        for(File m : fs)
        {
            if(m.getName().contains(will))
            {
                File ftemp=null;
                ftemp = new File(m.getAbsolutePath().replaceAll(will, to));
                m.renameTo(ftemp);
                
                
                
            }
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
    }
    
}
