package com.thoughtworks.classAndStudent.bean.AfterThrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfterThrowingCallMethod {
    @Autowired
    private AfterThrowingMethod method;

    public void callMethods() {
        method.one();
        method.two();
        method.three();
    }
}
