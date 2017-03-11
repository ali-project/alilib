/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ali
 */
public class MCTOMT4 {
    
    public static void main(String[] args) throws IOException {
        
        String url = "/Users/ali/NetBeansProjects/NLTrade/data/XAUUSD.log.min";
        
        List<String> strings = AliFile.getString(url);
        List<String> output = new ArrayList<String>();
        AliLog.println("begin...");
        for(int i=0;i<strings.size();i++)
        {
            String tmp [] = strings.get(i).split(",");
            //
            output.add(to0date(tmp[0])+","+to0time(tmp[1])+","+tmp[2]+","+tmp[3]+","+tmp[4]+","+tmp[5]+","+tmp[6]+"\n");
     //       AliFile.appendString(url+".mt4", );
            
            
            
        }
        AliLog.println("end...");
        AliLog.println("begin writing...");
        
        AliFile.append(url+".mt4.txt", output);
        
        
        
        
        
    }
    
    
    static String to0date(String x)
    {
        String [] a = x.split("/");
        String b = a[0];
        b += ".";
        if(a[1].length()==1){
            b+= "0";
        }
        b += a[1]+".";
        if(a[2].length()==1){
            b+= "0";
        }
        b += a[2];
        
        
        return b ;
    }
    
    static String to0time(String x)
    {
        String [] a = x.split(":");
        String b = "";
        
        if(a[0].length()==1){
            b+= "0";
        }
        b += a[0]+":";
        if(a[1].length()==1){
            b+= "0";
        }
        b += a[1];
        
        
        return b ;
    }
    
    
}
