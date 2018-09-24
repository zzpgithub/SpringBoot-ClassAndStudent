package com.thoughtworks.beijingGrad.springbootclassandstudent.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Method {
    @Autowired
    LogContainer logContainer;
    public void one() {
        logContainer.getMessages().add("one: "+ LocalDateTime.now());
    }

    public void two() {
        logContainer.getMessages().add("two: "+LocalDateTime.now());
    }

    public void three() {
        logContainer.getMessages().add("three: "+LocalDateTime.now());
    }
}
