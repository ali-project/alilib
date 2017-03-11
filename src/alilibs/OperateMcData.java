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
public class OperateMcData {
    
    public static void split(String url) throws IOException
    {
        List<String> lists = AliFile.getString(url);
        int lastYear = 0 ;
        List<String> output = new ArrayList<String>();
        for(int i=0;i<lists.size();i++)
        {
            
            
            String [] strs = lists.get(i).split(",");
            int year  = Integer.parseInt(strs[0].split("/")[0]) ;
            if((lastYear!=0 && year != lastYear ))
            {
                AliFile.append(url+"."+lastYear+".txt", output);
                output.clear();
                
            }
            output.add(lists.get(i));
            
            lastYear = year ;
            if(i==lists.size()-1 )
            {
                AliFile.append(url+"."+lastYear+".txt", output);
                output.clear();
                
            }
            
            
            
            
        }
        
        
        
    }
    
    
    
    public static  void add(String outputStrings,List<String> urls) throws IOException {
        for(int i = 0;i<urls.size();i++)
        {
            AliFile.append(outputStrings, AliFile.getString(urls.get(i)));
            
            
            
        }
        
        
        
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        //OperateMcData.split("/Users/ali/NetBeansProjects/NLTrade/data/NZDUSD.log.min");
        String url_ = "/Users/ali/NetBeansProjects/NLTrade/data/";
        List<String> x = new ArrayList<String>();
        for(int i=1999;i<=2014;i++)
        {
            x.add(url_+"AUD|NZD|EUR"+i+".txt");
            
            
        }
        OperateMcData.add(url_+"AUDNZDEUR.log.min", x);
    
    
    }
    
    
}
