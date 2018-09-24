package com.thoughtworks.classAndStudent.bean.Around;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AroundCallMethod {
    @Autowired
    private AroundMethod method;

    public void callMethods() {
        method.one();
        method.two();
        method.three();
    }
}
