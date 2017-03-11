/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import alilibs.AliFile;
import alilibs.AliLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * only for tick now 为套利做准备 .
 *
 * @author ali
 */
public class Data {

    String[] urls;

    public Data(String[] urls, String outputs) throws IOException {
        this.urls = urls;
        List<String> output = new ArrayList<String>();
        String outputstr = "";
        List<Map<String, String>> ms = new ArrayList<Map<String, String>>();
        for (int i = 1; i < urls.length; i++) {
            List<String> lists = AliFile.getString(urls[i]);
            Map<String, String> m = new HashMap<String, String>();
            for (int j = 0; j < lists.size(); j++) {
                String[] result = lists.get(j).split(",");
                m.put(i + "_" + result[0] + "|" + result[1], "" + result[2] + "_" + result[3] + "_" + result[4] + "_" + result[5]);
            }
            ms.add(m);

            AliLog.println(m.size());

        }

        List<String> lists2 = AliFile.getString(urls[0]);
        for (int i = 0; i < lists2.size(); i++) {
            String[] result = lists2.get(i).split(",");
            String outputtime = "" + result[0] + "," + result[1];
            String[] price = new String[4 + (ms.size() * 4)];
            price[0] = result[2];
            price[1] = result[3];
            price[2] = result[4];
            price[3] = result[5];
            boolean havenull = false;
            for (int j = 0; j < ms.size(); j++) {
                Map<String, String> m = ms.get(j);
                String at = m.get((j + 1) + "_" + result[0] + "|" + result[1]);
                //AliLog.println(at);
                if (at == null) {
                    havenull = true;
                    continue;
                }
                String[] price_ = at.split("_");
                price[4 + j * 4] = price_[0];
                price[5 + j * 4] = price_[1];
                price[6 + j * 4] = price_[2];
                price[7 + j * 4] = price_[3];

            }
            if (havenull) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                outputstr = "";
                outputstr += (outputtime);
                for (int j = 0; j < (int) (price.length / 4); j++) {

                    outputstr += ("," + price[k + j * 4]);

                }
                outputstr += "\n";
                AliFile.appendString(outputs, outputstr + "");
            }

        }

    }

    public static void main(String[] args) throws IOException {
        String url_ = "/Users/ali/NetBeansProjects/NLTrade/data/";

        for (int i = 1999; i <= 2014; i++) {

            new Data(new String[]{url_ + "AUDUSD/AUDUSD.log.min."+i+".txt",
                url_ + "NZDUSD/NZDUSD.log.min."+i+".txt",
                url_ + "EURUSD/EURUSD.log.min."+i+".txt"},
                    url_ + "AUD|NZD|EUR" + i + ".txt");

            System.gc();
        }

    }

}
