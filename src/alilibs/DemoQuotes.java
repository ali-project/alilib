/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Ali
 */
public class DemoQuotes {

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        DecimalFormat df = new DecimalFormat("0.00000");
        DecimalFormat df2 = new DecimalFormat("0.000");
        Map<String, Double> m = new HashMap<String, Double>();
        m.put("EURUSD", 1.0000 + (500 + r.nextInt(2000 - 500)) * 0.0001);
        m.put("USDJPY", 100.00 + (500 + r.nextInt(2000 - 500)) * 0.01);
        String url = "http://linux.9hlh.com:3000/quote.html";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (true) {

            int sleep = 500 + r.nextInt(2000 - 500);
            if (sleep % 2 == 0) {
                m.put("EURUSD", m.get("EURUSD") + sleep / 1000.0 / 10000.0);
                m.put("USDJPY", m.get("USDJPY") - sleep / 100.0 / 1000.0);

            } else {
                m.put("EURUSD", m.get("EURUSD") - sleep / 1000.0 / 10000.0);
                m.put("USDJPY", m.get("USDJPY") + sleep / 100.0 / 1000.0);
            }

            String pam =("EURUSD=" + df.format(m.get("EURUSD"))+"&USDJPY="+ df2.format(m.get("USDJPY")));
            
            String result = AliHTTP.getString(url+"?"+pam+"&count=2");
            AliLog.println(result);
            Thread.sleep(100);

        }

    }

}
