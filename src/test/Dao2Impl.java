package test;

import alilibs.AliLog;
import org.springframework.stereotype.Component;

/**
 * Created by 闲道人阿力 on 2016/8/31.
 */
@Component("dao2")
public class Dao2Impl implements IDao {
    @Override
    public void insert(String s) {
        AliLog.println("insert...."+s);
    }
}
