package com.thoughtworks.classAndStudent.bean.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CallMethod {
    @Autowired
    private Method method;

    public void callMethods() {
        method.one();
        method.two();
        method.three();
    }
}
