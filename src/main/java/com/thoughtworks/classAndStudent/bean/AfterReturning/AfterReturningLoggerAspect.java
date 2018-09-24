package com.thoughtworks.classAndStudent.bean.AfterReturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningLoggerAspect {
    @Autowired
    private AfterReturningLogContainer logContainer;

    @AfterReturning("@annotation(com.thoughtworks.classAndStudent.bean.AfterReturning.AfterReturningLogger)")
    public void logAfter(JoinPoint joinPoint ){
        String methodName = joinPoint.getSignature().getName();
        logContainer.getMessages().add("afterReturning");
    }
}
