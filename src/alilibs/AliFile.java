/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author a
 */
public class AliFile {
    
    
    public static List<File>  files =null; 
    
    public static List<File> getAllFiles(File f){
        if(files == null)
          files= new ArrayList<File>();
        if(f!=null){
            if(f.isDirectory()){
                File[] fileArray=f.listFiles();
                if(fileArray!=null){
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        getAllFiles(fileArray[i]);
                    }
                }
            }
            else{
                //System.out.println(f);
                files.add(f);
            }
        }
        return files ;
    }
    
    public static File[] getFiles2(File f)
    {
        
        return f.listFiles();
    }
    
    
    public static List<String> getString(String url)
    {
        
        File f = new File(url);
        try {
            return FileUtils.readLines(f);
        } catch (IOException ex) {
            return  null ;
        }
 
        
    }
    
    
    public static void  copyfile (String urldir,File f) throws Exception
    {
        FileUtils.copyFileToDirectory(f, new File(urldir),true);
    }
    
    //FUCK YOU FUCK ME FUCK IT ALWAYS  //fucks
    public static void append(String filename,List<String>list ) throws IOException
    {
        File f = new File(filename);
        FileUtils.writeLines(f, list, true);
        
        //
        
    }
    public static void appendString(String filename,String str ) throws IOException
    {
        File f = new File(filename);
        
        
        FileUtils.writeStringToFile(f, str, true);
        
        //
        
    }
    public static void delete(String filename) throws IOException
    {
        File f = new File(filename);
        FileUtils.deleteQuietly(f);
        
        
        
    }
    public static void writenew(String url ,List<String> values)
    {
        try {
            FileUtils.writeLines(new File(url), values, false);




        } catch (IOException ex) {
        }
    }
    public static void writenew(String url ,String values)
    {
        try {
            FileUtils.write(new File(url), values, false);
        } catch (IOException ex) {
        }
    }
    
    
    public static boolean isExit(String filename)
    {
        
        File f = new File(filename);
        return  f.exists();
        
    }
    
    
}
