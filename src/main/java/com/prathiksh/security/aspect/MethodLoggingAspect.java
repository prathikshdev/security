package com.prathiksh.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLoggingAspect {

    @Around("execution(* com.prathiksh.security.oauth.TestController.testOauth())")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before calling testOauth method");
        Object obj = joinPoint.proceed();
        System.out.println("After calling testOauth method");
        return obj;
    }

}
