/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author a
 */
public class AliConfig {

    private boolean haveloadkey = false;
    private Map<String, String> keywords;

    /**
     * 配置文件读取Init
     *   fsfa
     * @param url 存储路径
     * @param key key [user]
     */
    
    public AliConfig(String url, String key) {

        List<String> config = AliFile.getString(url);
        keywords = new HashMap<>();
        for (int i = 0; i < config.size(); i++) {

            if (config.get(i).startsWith("#")) {
                continue;
            }

            if (config.get(i).contains("[") && config.get(i).contains("]")) {
                if (config.get(i).contains(key)) {
                    haveloadkey = true;
                    continue;
                } else if (haveloadkey) {
                    break;
                }

            }

            if (haveloadkey == false) {
                continue;
            }
            String[] x = config.get(i).split("=");
            if (x.length == 2) {
                keywords.put(x[0], x[1]);
            }

        }

    }

    public Map<String, String> getKeyWords() {
        return keywords;
    }

    public String getByKey(String key) {

        return keywords.get(key);

    }

}
