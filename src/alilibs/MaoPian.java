package alilibs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闲道人阿力 on 2016/6/23.
 */
public class MaoPian {






    public static void main(String args[]) throws IOException {

        List<String> str = AliFile.getString("f.txt");





        for(int i=0;i<str.size();i++)
        {
            String [] sss = str.get(i).split("----------") ;
            if(sss.length!=3){
                if(str.get(i).contains("ed2k://")){

                    String str2[] = sss[sss.length-2].split("/") ;
                   // AliFile.appendString("maotujpg.txt","wget "+sss[sss.length-2]+"\n");
                    //insert into ed2k (name,img,ed2k) values('111','222','333')
                    AliFile.appendString("sql.txt","insert into ed2k (name,img,ed2k) values('"+
                            sss[sss.length-3].replaceAll("'"," ")+"','"+str2[str2.length-1]+"','"+sss[sss.length-1]+"');\n");
                }

            }else{
                //AliLog.println(i+"  "+str.get(i)+"");
                String str2[] = sss[sss.length-2].split("/") ;
               // AliFile.appendString("maotujpg.txt","wget "+ sss[sss.length-2]+"\n");

                //AliFile.appendString("ed2kresult.txt",sss[sss.length-3]+"----------"+str2[str2.length-1]+"----------"+sss[sss.length-1]+"\n");
                AliFile.appendString("sql.txt","insert into ed2k (name,img,ed2k) values('"+
                        sss[sss.length-3].replaceAll("'"," ")+"','"+str2[str2.length-1]+"','"+sss[sss.length-1]+"');\n");






            }

        }




//            for(int i=6779;i<=9790;i++)
//            {
//                try {
//                    getliebiao("http://www.5060lu.com/vod/"+i+".html");
//                } catch (Exception e) {
//                    return;
//                }
//                AliLog.println(i+"");
//            }




/*
        args = new String[]{
                "http://www.5060lu.com/list/1.html","403",
                "http://www.5060lu.com/list/2.html","47",
                "http://www.5060lu.com/list/3.html","40",
                "http://www.5060lu.com/list/4.html","20",
                "http://www.5060lu.com/list/5.html","11",
                "http://www.5060lu.com/list/6.html","11",
                "http://www.5060lu.com/list/7.html","8",
        };

        for(int i=0;i<args.length;i=i+2)
        {


            AliLog.println(args[i]);
            int pages = new Integer(args[i+1]);
            for(int j=2;j<=pages;j++){
                AliLog.println("http://www.5060lu.com/list/"+(i/2+1)+"-"+j+".html");
            }





        }
*/
    }


    static void getliebiao(String url) throws Exception {
        String x = AliHTTP.getStringb(url);
        AliLog.println(x);
        char[] b = x.toCharArray();
        boolean iso = false ;
        boolean iso2 = false ;
        boolean iso3 = false ;

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for(int i=0;i<b.length;i++)
        {
            if(i>10 &  iso==false && b[i]=='>' && b[i-1]=='e' && b[i-2]=='l' && b[i-3]=='t'&& b[i-4]=='i' && b[i-5]=='t' && b[i-6]=='<'){
                //AliLog.println(b[i]);
                iso = true ;
                continue;
            }
            if(iso==true &&  b[i+1]=='<'&&  b[i+2]=='/'){
                //AliLog.println(b[i]);
                //AliLog.println(sb.toString());
                AliFile.appendString("mov.txt",sb.toString()+"|||||");
                iso = false ;
                sb = new StringBuilder();
                continue;
            }
            if(iso==true ){
                sb.append(b[i]);
            }

            if( iso2==false && b[i]=='"' && b[i-1]=='=' && b[i-2]=='c' && b[i-3]=='r'&& b[i-4]=='s' && b[i-5]==' ' && b[i-6]=='g'&& b[i-7]=='m' && b[i-8]=='i' && b[i-9]=='<'&& b[i-10]=='>' && b[i-11]=='"' && b[i-12]=='c'){
                //AliLog.println(b[i]);
                iso2 = true ;
                continue;
            }
            if(iso2==true &&  b[i]=='"'){
                //AliLog.println(b[i]);
                //AliLog.println(sb2.toString());
                AliFile.appendString("mov.txt",sb2.toString()+"|||||");
                iso2 = false ;
                sb2 = new StringBuilder();
                continue;
            }
            if(iso2==true ){
                sb2.append(b[i]);
            }


            if( iso3==false && b[i]=='"' && b[i+1]=='e' && b[i+2]=='d' && b[i+3]=='2' && b[i+4]=='k'&& b[i+5]==':' ){
                //AliLog.println(b[i]);
                iso3 = true ;
                continue;
            }
            if(iso3==true &&  b[i]=='"'){
                //AliLog.println(b[i]);
                //AliLog.println(sb3.toString());
                AliFile.appendString("mov.txt",sb3.toString()+"\n");
                iso3 = false ;
                sb3 = new StringBuilder();
                return ;
            }
            if(iso3==true ){
                sb3.append(b[i]);
            }


        }





    }



















}
