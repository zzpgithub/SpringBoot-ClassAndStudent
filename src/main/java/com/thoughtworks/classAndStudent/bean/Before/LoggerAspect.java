package com.thoughtworks.classAndStudent.bean.Before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    @Autowired
    private LogContainer logContainer;

    @Before("@annotation(com.thoughtworks.classAndStudent.bean.Before.Logger)")
    public void logBefore(JoinPoint joinPoint ){
        String methodName = joinPoint.getSignature().getName();
        logContainer.getMessages().add("before");
    }
}
