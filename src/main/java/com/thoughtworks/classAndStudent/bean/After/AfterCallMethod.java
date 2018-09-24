package com.thoughtworks.classAndStudent.bean.After;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AfterCallMethod {
    @Autowired
    private AfterMethod method;

    public void callMethods() {
        method.one();
        method.two();
        method.three();
    }
}
