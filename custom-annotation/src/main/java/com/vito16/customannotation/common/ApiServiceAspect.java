package com.vito16.customannotation.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/11/09
 */
@Aspect
@Component
public class ApiServiceAspect {

    @Around("@annotation(ApiService)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before.....");
        Object obj = joinPoint.proceed();
        System.out.println("after.....");
        return obj;
    }

}
