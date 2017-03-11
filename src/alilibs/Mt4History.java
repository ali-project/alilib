package alilibs;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ali on 2016/12/22.
 */
public class Mt4History {

    public static void main(String []args)
    {
        export("C:/Users/Ali/Desktop/Statement_816246.htm","eurusd");
        export("C:/Users/Ali/Desktop/Statement_816246.htm","usdjpy");
        export("C:/Users/Ali/Desktop/Statement_816246.htm","audusd");
        export("C:/Users/Ali/Desktop/Statement_816246.htm","gbpusd");



    }


    public static void export(String path,String symbol)
    {
        List<String> result =getarray(path);
        List<String> print = new ArrayList<String>();
        print.add(gethead());



        for(int i=0;i<result.size();i++)
        {
            String[] ttt = result.get(i).split(",");
            //System.out.println(ttt.length);
            if(!ttt[4].equals(symbol)) continue;

            try {
                print.add(jiaoyi(ttt[2],ttt[4],ttt[5],ttt[9],ttt[1],ttt[8],ttt[3]));
            } catch (Exception e) {
                e.printStackTrace();
            }


            //System.out.println(result.get(i));
        }
        //System.out.println(getfoot());
        print.add(getfoot());

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.ddHHmmss");


            AliFile.append("C:\\Users\\Ali\\Desktop\\"+symbol+sdf.format(new Date())+".tpl",print);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public static List<String> getarray(String path)
    {
        List<String> aaa = AliFile.getString(path);
        List<String> resultlist = new ArrayList<String>();
        for(int i=0;i<aaa.size();i++)
        {
            String xxx = aaa.get(i);
            if(!xxx.contains("colspan=4")&&!xxx.contains("colspan=10")&& xxx.length()>200){

                boolean flag = false ;
                String result = "";
                String result2 = "";
                for(int j=0;j<xxx.length();j++)
                {
                    String yyy = xxx.substring(j,j+1);
                    if(yyy.equals("<")){
                        flag = false ;
                        //System.out.println(result);
                        if(result.length()>0){
                            result2 += result+",";
                        }


                    }
                    if(flag){
                        result += yyy ;
                    }


                    if(yyy.equals(">")){
                        result = "";
                        flag = true ;
                    }



                    // System.out.println(yyy);


                }

                //System.out.println(result2);
                resultlist.add(result2);






            }




        }
        return  resultlist ;
    }


    public static String gethead(){
        String aaa = "<chart>\n";
        aaa += "id=131268652886235851";
        aaa += "symbol=GBPCAD";
        aaa+="period=1\n";
        aaa+="leftpos=1190\n";
        aaa+="offline=1\n";
        aaa+="digits=5\n";
        aaa+="scale=8\n";
        aaa+="graph=1\n";
        aaa+="fore=0\n";
        aaa+="grid=0\n";
        aaa+="volume=0\n";
        aaa+="scroll=1\n";
        aaa+="shift=1\n";
        aaa+="ohlc=1\n";
        aaa+="one_click=0\n";
        aaa+="one_click_btn=0\n";
        aaa+="askline=0\n";
        aaa+="days=0\n";
        aaa+="descriptions=0\n";
        aaa+="shift_size=20\n";
        aaa+="fixed_pos=32\n";
        aaa+="window_left=0\n";
        aaa+="window_top=0\n";
        aaa+="window_right=1049\n";
        aaa+="window_bottom=268\n";
        aaa+="window_type=3\n";
        aaa+="background_color=0\n";
        aaa+="foreground_color=16777215\n";
        aaa+="barup_color=65280\n";
        aaa+="bardown_color=65280\n";
        aaa+="bullcandle_color=0\n";
        aaa+="bearcandle_color=16777215\n";
        aaa+="chartline_color=65280\n";
        aaa+="volumes_color=3329330\n";
        aaa+="grid_color=10061943\n";
        aaa+="askline_color=255\n";
        aaa+="stops_color=255\n";
        aaa+="<window>\n";
        aaa+="height=100\n";
        aaa+="fixed_height=0\n";
        aaa+="<indicator>\n";
        aaa+="name=main\n";



        return aaa;

    }

    public static String getfoot(){
        String aaa = "</indicator>\n";
        aaa += "</window>\n";
        aaa += "</chart>\n";
        return  aaa ;
    }

    public static String jiaoyi(String cmd ,String symbol,String openprice,String closeprice,String opentime,String closetime,String lots) throws Exception

    {

        if(closetime.length()<8) return  "";


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date open = sdf.parse(opentime);
        Date close  = sdf.parse(closetime);
        long open2 = open.getTime()/1000+8*60*60;
        long close2 = close.getTime()/1000+8*60*60;



//开单

        String aaa = "<object>\n" ;
        aaa+="type=22\n";
        aaa+= "object_name="+symbol+System.currentTimeMillis()+"_"+Math.random()+"\n";
        aaa += "period_flags=0\n";
        aaa += "create_time="+(System.currentTimeMillis()/1000)+"\n";
        aaa+="description=(20131111)\n";
        aaa+="color=";
        if(cmd.equals("sell")){
            aaa+="255\n";
        }else if(cmd.equals("buy")){
            aaa+="16711680\n";
        }


        aaa += "weight=1\n";
        aaa += "background=0\n";
        aaa += "symbol_code=1\n";
        aaa += "anchor_pos=0\n";
        aaa += "filling=0\n";
        aaa += "selectable=1\n";
        aaa += "hidden=0\n";
        aaa += "zorder=0\n";
        aaa += "time_0="+open2+"\n";
        aaa += "value_0="+openprice+"\n";
        aaa += "</object>\n" ;

        //平
        aaa += "<object>\n" ;
        aaa+="type=22\n";
        aaa+= "object_name="+System.currentTimeMillis()+"_"+Math.random()+"\n";
        aaa += "period_flags=0\n";
        aaa += "create_time="+(System.currentTimeMillis()/1000)+"\n";

        aaa+="color=2139610\n";
        aaa += "weight=1\n";
        aaa += "background=0\n";
        aaa += "symbol_code=3\n";
        aaa += "anchor_pos=0\n";
        aaa += "filling=0\n";
        aaa += "selectable=1\n";
        aaa += "hidden=0\n";
        aaa += "zorder=0\n";
        aaa += "time_0="+close2+"\n";
        aaa += "value_0="+closeprice+"\n";
        aaa += "</object>\n" ;

        //画线
        aaa += "<object>\n" ;
        aaa+="type=2\n";
        aaa+= "object_name="+System.currentTimeMillis()+"_"+Math.random()+"\n";
        aaa += "period_flags=0\n";
        aaa += "create_time="+(System.currentTimeMillis()/1000)+"\n";

        aaa+="color=";
        if(cmd.equals("sell")){
            aaa+="255\n";
        }else if(cmd.equals("buy")){
            aaa+="16711680\n";
        }
        aaa+="style=2\n";
        aaa += "weight=1\n";
        aaa += "background=0\n";
        aaa += "symbol_code=3\n";
        aaa += "anchor_pos=0\n";
        aaa += "filling=0\n";
        aaa += "selectable=1\n";
        aaa += "hidden=0\n";
        aaa += "zorder=0\n";
        aaa += "time_0="+open2+"\n";
        aaa += "value_0="+openprice+"\n";
        aaa += "time_1="+close2+"\n";
        aaa += "value_1="+closeprice+"\n";
        aaa+= "ray=0\n";
        aaa += "</object>\n" ;


        //头寸
        aaa+="<object>\n";
        aaa+="type=21\n";
        aaa+="object_name=Text 37920\n";
        aaa+="period_flags=0\n";
        aaa+="create_time="+(System.currentTimeMillis()/1000)+"\n";
        aaa+="description="+lots+"\n";
        aaa+="color=255\n";
        aaa+="font=Arial\n";
        aaa+="fontsize=10\n";
        aaa+="angle=0\n";
        aaa+="anchor_pos=7\n";
        aaa+="background=0\n";
        aaa+="filling=0\n";
        aaa+="selectable=1\n";
        aaa+="hidden=0\n";
        aaa+="zorder=0\n";
        aaa+="time_0="+open2+"\n";
        aaa+="value_0="+openprice+"\n";
        aaa+="</object>\n";

        return  aaa ;
    }



}
