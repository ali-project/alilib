package test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by 闲道人阿力 on 2016/10/17.
 */
@Aspect
@Component
public class Accept {
    @Before("execution( * test.*(..))")
    public void before(JoinPoint joinPoint)
    {
        System.out.println("============================="+joinPoint.getSignature().getName());
    }



}
