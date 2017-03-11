package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by 闲道人阿力 on 2016/8/27.
 */
@Component
public class Person {



    @Autowired
    private Config c ;

    @Autowired
    @Qualifier("dao2")
    private IDao ccc ;


    public IDao getDao() {
        return ccc;
    }

    public void setCcc(IDao ccc) {
        this.ccc = ccc;
    }

    public Config getC() {
        return c;
    }

    public void setC(Config c) {
        this.c = c;
    }


    public void fuck(){




    }


}
