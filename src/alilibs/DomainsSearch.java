/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author a
 */
public class DomainsSearch {

    
    
    static PrintWriter pw = null ;
    
    
    /**
     * 用来搜索域名有没有被注册 .结果将显示在本地的一个txt文件里
     * @param houzui  后缀 比如.com .cn
     * @param list 是一个需要查询的集合
     * @param count 这个集合从多少开始
     * @throws Exception 
     */
    
    
    public static void search(String houzui,List<String> list ,int count) throws Exception
    {
        
        
        String path = System.getProperty("user.dir");
         pw = new PrintWriter(new FileOutputStream(new File(path+"/"+System.currentTimeMillis()+"result.txt")));
        
        
        
        
        //List<String> list = new ArrayList<String>();
        //String [] aaa = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","","9","0"};
        
        for(int i=0;i<list.size();i++)
        {
            
            gogo("http://whois.chinaz.com/"+list.get(i)+houzui,count);
            
            
        }
        
        
        /*
        
        for(int i=0;i<aaa.length;i++)
        {
            
            list.add(aaa[i]);
        }
        
        
        int count = 0;

        
        
        
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.size();j++)
            {
            for(int k=0;k<list.size();k++)
            {
                for(int l=0;l<list.size();l++)
            {
                count++ ; 
                
                //System.out.println(list.get(i)+""+list.get(j));
                
                if(count <c) continue ;
                
                
                //Thread.sleep(100);
                //http://whois.chinaz.com/ifis009900909.com
                

                
        
                //System.out.println("http://whois.chinaz.com/"+list.get(i)+""+list.get(j)+"fsaffasf.com");
                //http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=
                
                gogo("http://whois.chinaz.com/"+list.get(i)+""+list.get(j)+list.get(k)+houzui,count);
        
        
        
        
                
                
                
                
            }
            
            }
            }
            
            
        }
        
        
        
        */
        
        
        
    }
    
    
    
    public static void gogo(String url,int count)
    {
        String result2 = "";
                

                 result2 = AliHTTP.getString(url);
        if(result2.contains("该域名未被注册"))
        
        {
        System.out.println(url);
        pw.println(url);
        pw.flush();
        
        }
        else
        {
            System.out.println("-"+count);
            pw.println("-"+count);
            pw.flush();
        }
        
        
    }
}
