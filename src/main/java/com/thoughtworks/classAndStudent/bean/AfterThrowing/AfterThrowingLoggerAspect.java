package com.thoughtworks.classAndStudent.bean.AfterThrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingLoggerAspect {
    @Autowired
    private AfterThrowingLogContainer logContainer;

    @AfterThrowing("@annotation(com.thoughtworks.classAndStudent.bean.AfterThrowing.AfterThrowingLogger)")
    public void logAfter(JoinPoint joinPoint ){
        String methodName = joinPoint.getSignature().getName();
        logContainer.getMessages().add("afterThrowing");
    }
}
