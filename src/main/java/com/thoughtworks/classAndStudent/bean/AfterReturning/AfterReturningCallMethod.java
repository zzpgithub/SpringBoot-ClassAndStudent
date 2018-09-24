package com.thoughtworks.classAndStudent.bean.AfterReturning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfterReturningCallMethod {
    @Autowired
    private AfterReturningMethod method;

    public void callMethods() {
        method.one();
        method.two();
        method.three();
    }
}
