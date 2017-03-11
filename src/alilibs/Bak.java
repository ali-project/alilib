/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.io.File;
import java.util.List;

/**
 *
 * @author Ali
 */
public class Bak {
    
    public static void main(String[] args) throws Exception {
        
        String from = "C:"+File.separator+"a"+File.separator+"b";
        String to = "C:"+File.separator+"a"+File.separator+"c";
        if(args.length>0)
        {
            from = args[0];
            to = args[1];
        }
        System.out.println(from+"->"+to);
        
        
        AliFile.files = null ;
        List<File> files =AliFile.getAllFiles(new File(from));
        System.out.println("Files count->"+files.size());
        
        long max = 0L ;
        List<String> lasttime= AliFile.getString("lasttime");
        if(lasttime!=null){
            max  = Long.parseLong(lasttime.get(0));
        }
        String aaax = System.currentTimeMillis()+"";
        
        
        
        for(int i=0;i<files.size();i++)
        {
            if(files.get(i).lastModified()>max)
            {
                
                System.out.println("copy->"+files.get(i).getAbsolutePath());
                String aaa = files.get(i).getAbsolutePath().substring(from.length());
                //max = files.get(i).lastModified() ;
                String bbb[] = aaa.split("\\"+File.separator);
                String output = "";
                
                for(int j=0;j<bbb.length;j++)
                {
                    
                    String ccc = "";
                    if(j<bbb.length-1)
                    {
                        output += bbb[j]+File.separator;
                    }
                    
                    
                    
                    for(int k = 0 ;k<j;k++)
                    {
                        if(bbb[k].length()>0)
                        ccc+=(File.separator+bbb[k]);
                        
                    }
                    
                    
                    File dirs = new File(to+ccc);
                    if(!dirs.exists()){
                        System.out.println("make a dirict ->："+to+ccc);
                        dirs.mkdir();
                    }
                    
                    
                }
                
                AliFile.copyfile(to+output, files.get(i));
                
            }
            
        }
        AliFile.writenew("lasttime", aaax);
        
    }
    
    
    
}
