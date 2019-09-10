package com.ty.dongba.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.dongba.dao.TyLogDao;
import com.ty.dongba.entity.TyLog;
import com.ty.dongba.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 分装扩展功能
 *
 * 控制执行
 */
@Aspect
@Slf4j
@Component
public class TyLogAspect {

    /**
     * pointcut 定义切入点
     * 这个不需要
     */
    @Pointcut("bean(*ServiceImpl)")
    public void logPointCut(){}

    @Autowired
    private TyLogDao tyLogDao;

    //@Around("logPointCut()")
    @Around("@annotation(LogAnn)")
    public Object LogSaveService(ProceedingJoinPoint point) throws Throwable{

        long startTime = System.currentTimeMillis();
        //log.info("start "+System.currentTimeMillis());

        //调用目标方法
        Object proceed = point.proceed();

        long endTime = System.currentTimeMillis();

        long totalTime = endTime-startTime;
        log.info("程序执行的时间是 "+ totalTime);
        //log.info("after "+System.currentTimeMillis());

        //插入日志
        saveLog(point,totalTime);

        return proceed;

    }

    private void saveLog(ProceedingJoinPoint point, long totalTime) throws NoSuchMethodException, JsonProcessingException {

        //1.获取日志信息
        // 目标方法签名 (封装了方法相关信息)
        MethodSignature ms = (MethodSignature) point.getSignature();
        //获取目标 对象的 字节码对象
        Class<?> targetCls = point.getTarget().getClass();
        //获取目标类型 的 方法
        Method method = ms.getMethod();

        String methodName = targetCls.getName()+"."+method.getName();
        //判断目标方法是否有 log注解

        //获取方法参数，并且转化为字符串
        Object[] args = point.getArgs();
        ObjectMapper om = new ObjectMapper();
        String params = om.writeValueAsString(args);

        //获取注解zhi 定义的操作值
        String operation = "operation";
        LogAnn annotation = method.getAnnotation(LogAnn.class);
        if (annotation != null) {
            operation = annotation.operation();
        }

        //2. 封装日志信息
        TyLog tyLog = new TyLog();
        tyLog.setId(1).setIp(IPUtils.getIpAddr())
                .setMethod(methodName) //类全名 + 方法名
                .setParams(params) // 执行方法的时候传递的参数
                .setOperation(operation)
                .setUsername("admin")
                .setCreatedTime(new Date())
                .setTime(totalTime);



        //3。保存用户信息
        tyLogDao.insertLog(tyLog);
    }


}
