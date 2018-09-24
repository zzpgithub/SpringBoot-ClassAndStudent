package com.thoughtworks.classAndStudent.bean.Around;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundLoggerAspect {
    @Autowired
    private AroundLogContainer logContainer;

    @Around("@annotation(com.thoughtworks.classAndStudent.bean.Around.AroundLogger)")
    public void logBefore(ProceedingJoinPoint joinPoint ) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logContainer.getMessages().add("around before");
        joinPoint.proceed();
        logContainer.getMessages().add("around end");
    }
}
