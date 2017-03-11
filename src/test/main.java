package test;

import alilibs.AliHTTP;
import alilibs.AliLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 闲道人阿力 on 2016/8/27.
 */
public class main {
    public static void main(String []args){

//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Person p = ac.getBean(Person.class);
//        p.fuck();
//        System.out.println(p.getC());
//        AliLog.println(p.getDao());


        int now = 11 ;
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        int only = 10 ;
        for(int i=1;i<=arr.length;i++){
            now = i ;


            int from = 1 ;
            if(now>only-2){
                from = now-2 ;
            }

            if(now>arr.length-only){
                from = arr.length-only;
            }

            AliLog.println(now+"=>"+from);


        }




    }
}
