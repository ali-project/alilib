package alilibs;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author a
 */
public class MCToTick {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
	
	double min = 0.1;
	
	
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    	String filename = "/Volumes/新加卷/mc data/XAUUSD.log.min";
    	DecimalFormat df = new DecimalFormat("#.00000");
    	
    	File file = new File(filename);
    	FileReader fr = new FileReader(file);
    	   BufferedReader bf = new BufferedReader(fr);
    	PrintWriter pw = new PrintWriter(new File(filename+".tick"));
    	   
    	   
    	   
    	String x="";
    	while((x=bf.readLine())!=null)
    	{
    		//System.out.println(x);
    		
    		if(x.contains("Date")) continue ;
    		
    		
    		String [] temp = x.split(",");
    		String [] date = temp[0].split("/");
    		String [] time = temp[1].split(":");
    		
            Calendar can = Calendar.getInstance();
            can.set(Calendar.YEAR, new Integer(date[0]));
            can.set(Calendar.MONTH, new Integer(date[1])-1);
            can.set(Calendar.DAY_OF_MONTH, new Integer(date[2]));
            can.set(Calendar.HOUR_OF_DAY, new Integer(time[0]));
            can.set(Calendar.MINUTE,new Integer(time[1]));
    		
            pw.print( new MCToTick().run(can,new Double(temp[2]),new Double(temp[3]),new Double(temp[4]),new Double(temp[5]),df));
    		
    		
    		
    		
    		
    	}
    	
    	
    	

    	System.out.println("--------------OK---------------");
    	
    	
    	
    	
    	

        
        
        
        
        
        

        
    }
    
    
    //can.set(2015, 3      -1, 1, 0, 0);
    
    
    
    String run(Calendar can,double o,double h,double l,double c,DecimalFormat df)
    {
        String temp = "";
        
        //Calendar can = Calendar.getInstance();
        //can.set(2015, 3      -1, 1, 0, 0);
        can.add(Calendar.MINUTE, -1);

        //DecimalFormat df = new DecimalFormat("#.00000");
        


        
        
        //double o = 1.34257;
        //double h = 1.34597;
        //double l = 1.34206;
        //double c = 1.34597;
        boolean isup = true;
        if(c<o) isup = false ;
        
        String time = can.get(Calendar.YEAR)+"-"+(can.get(Calendar.MONTH)+1)+"-"+can.get(Calendar.DAY_OF_MONTH)+","+
                can.get(Calendar.HOUR_OF_DAY)+":"+can.get(Calendar.MINUTE)+":";
        //System.out.println(time);
        if(isup)
        {
            temp+=(time+"00.00,"+ o+",100\r\n");
            double zengzhang = o;
            int second =0;
            while((zengzhang-=min)>l)
            {
                second++;
                if(second>=15) break ;
                temp+=(time+""+second+".00,"+    df.format(zengzhang)+",100\r\n");
            }
            
            temp+=(time+"15.00,"+l+",100\r\n");
            zengzhang = l;
            second=15;
            while((zengzhang+=min)<h)
            {
                second++;
                if(second>=45) break ;
                temp+=(time+""+second+".00,"+df.format(zengzhang)+",100\r\n");
            }
            temp+=(time+"45.00,"+h+",100\r\n");
            zengzhang = h;
            second = 45;
            while((zengzhang-=min)>c)
            {
                second ++;
                if(second>=59) break ;
                temp+=(time+""+second+".00,"+df.format(zengzhang)+",100\r\n");
            }
            
            temp+=(time+"59.00,"+c+",100\r\n");

        }else{
            temp+=(time+"00.00,"+o+",100\r\n");
            double zengzhang = o;
            int second = 0;
            while((zengzhang+=min)<h)
            {
                second++;
                if(second>=15) break ;
                temp+=(time+""+second+".00,"+df.format(zengzhang)+",100\r\n");
            }
            
            //System.out.println(time+"15,"+h+"\n");
            temp+=(time+"15.00,"+h+",100\r\n");
            zengzhang = h;
            second=15;
            
            while((zengzhang-=min)>l)
            {
                second++;
                if(second>=45) break ;
                temp+=(time+""+second+".00,"+ df.format(zengzhang)+",100\r\n");
            }
            temp+=(time+"45.00,"+l+",100\r\n");
            zengzhang = l;
            second=45;
            while((zengzhang+=min)<c)
            {
                second++;
                if(second>=59) break ;
                temp+=(time+""+second+".00,"+df.format(zengzhang)+",100\r\n");
            }
            
            temp+=(time+"59.00,"+c+",100\r\n");            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        return temp;
        
        
    }
    

    
}