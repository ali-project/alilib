/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author a
 */
public class AliLog {
    
    
    static Logger log;
    
    
    
    public static void init()
    {
        if(log==null)
            
        {
            //>>>
            log= Logger.getLogger("ALILOG");   
            BasicConfigurator.configure();//默认配置   
            PropertyConfigurator.configure("../config/log4j.properties");
            info(Class.class, "初始化日志成功");
            
            
        }
        
        
        
    }
    
    public static  void error(Object o,String message)
    {
        
            init();
            
            log.error("["+o.getClass().getName() +"<"+Thread.currentThread().getStackTrace()[2].getMethodName()+">]"+message);   
            
    }
    public static  void info(Object o,String message)
    {
        
            init();
            log.info("["+o.getClass().getName() +"<"+Thread.currentThread().getStackTrace()[2].getMethodName()+">]"+message);
    }
    public static  void debug(Object o,String message)
    {
        
            init();
            log.debug("["+o.getClass().getName() +"<"+Thread.currentThread().getStackTrace()[2].getMethodName()+">]"+message); 
    }
    public static  void warn(Object o,String message)
    {
        
            init();
            log.warn("["+o.getClass().getName() +"<"+Thread.currentThread().getStackTrace()[2].getMethodName()+">]"+message);
            error(message);
    }
    public static  void fatal(Object o,String message)
    {
        
            init();
            log.fatal("["+o.getClass().getName() +"<"+Thread.currentThread().getStackTrace()[2].getMethodName()+">]"+message);
            error(message);
    }
    /**
     * 就是sysout
     * @param str 
     */
    public static  void println(Object str)
    {
        System.out.println(str);
        
        
        
    }
    public static  void print(Object str)
    {
        System.out.print(str);
        
        
        
    }
    public static  void error(Object str)
    {
        System.err.println(str);
        
        
        
    }
    
    
}
