package com.ty.dongba.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceCacheAspect {

    @Around("execution(* com.ty.dongba.service..*.find*(..))")
    public Object cacheService(ProceedingJoinPoint point) throws Throwable{

        //1. 从cache 取得数据

        //2 cache 没有就从数据库里取得数据,并且放入缓存
        Object result = point.proceed();


        //3。 return 查到的数据
        return result;
    }
}
