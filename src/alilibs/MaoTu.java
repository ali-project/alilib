package alilibs;

import java.io.IOException;

/**
 * Created by 闲道人阿力 on 2016/6/22.
 */
public class MaoTu {


    static void getimgs(String url) throws Exception {
        String x = AliHTTP.getStringb(url);
        char[] b = x.toCharArray();
        //AliLog.println(b.length);
        boolean iso = false ;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<b.length;i++)
        {
            if(iso==false && b[i]=='"'){
                //AliLog.println(b[i]);
                iso = true ;
                continue;
            }
            if(iso==true && b[i]=='"'){
                //AliLog.println(b[i]);
                iso = false ;

                if(sb.toString().contains(".jpg")){


                        //AliLog.println(sb.toString());
                    try {
                        AliFile.appendString("jpg.txt","wget "+sb.toString()+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }



                sb = new StringBuilder();
                continue;
            }
            if(iso==true ){
                sb.append(b[i]);
            }







        }





    }


    static void getliebiao(String url) throws Exception {
        String x = AliHTTP.getStringb(url);
        char[] b = x.toCharArray();
        //AliLog.println(b.length);
        boolean iso = false ;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<b.length;i++)
        {
            if(iso==false && b[i]=='"'){
                //AliLog.println(b[i]);
                iso = true ;
                continue;
            }
            if(iso==true && b[i]=='"'){
                //AliLog.println(b[i]);
                iso = false ;

                if(sb.toString().contains("/html/tupian/") && !sb.toString().contains("getElementById")){

                   // if(sb.toString().split("/").length==7){
                        AliLog.println(sb.toString());
                        getimgs("http://www.5060lu.com"+sb.toString());
                   // }



                }



                sb = new StringBuilder();
                continue;
            }
            if(iso==true ){
                sb.append(b[i]);
            }







        }





    }




    public static void main(String args[]) throws Exception {

            int yema = 119 ;




            getliebiao("http://www.5060lu.com/html/tupian/qingchun/index.html");

        for(int i=71;i<=yema;i++)
        {
            getliebiao("http://www.5060lu.com/html/tupian/qingchun/index_"+yema+".html");
            AliLog.println("-----"+i+"-----");
        }







    }




}
