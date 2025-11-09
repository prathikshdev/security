package com.prathiksh.security.interceptors.custominterceptor;

import com.prathiksh.security.customannotation.CheckExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class ExecutionMetricsAspect {

    @Around("@annotation(com.prathiksh.security.customannotation.CheckExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("in calculateExecutionTime");
        Long startTime = System.currentTimeMillis();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        CheckExecutionTime checkExecutionTime = method.getAnnotation(CheckExecutionTime.class);
        String maxCompletionTime = checkExecutionTime.maxCompletionTime();
        Object obj = joinPoint.proceed();
        Long completeTime = System.currentTimeMillis() - startTime;
        System.out.println("Execution completed in : "+completeTime + " max time for execution is :"+ maxCompletionTime);
        return obj;
    }


}
