package test;

/**
 * Created by 闲道人阿力 on 2016/8/31.
 */
public class Config {


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Config{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private String key ;
    private String value ;
}
