package com.thoughtworks.classAndStudent.bean.After;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterLoggerAspect {
    @Autowired
    private AfterLogContainer logContainer;

    @After("@annotation(com.thoughtworks.classAndStudent.bean.After.AfterLogger)")
    public void logAfter(JoinPoint joinPoint ){
        String methodName = joinPoint.getSignature().getName();
        logContainer.getMessages().add("after");
    }
}
