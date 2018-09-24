package com.thoughtworks.classAndStudent.bean.Around;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AroundMethod {
    @Autowired
    AroundLogContainer logContainer;
    @AroundLogger
    public void one() {
        logContainer.getMessages().add("one: "+ LocalDateTime.now());
    }
    @AroundLogger
    public void two() {
       logContainer.getMessages().add("two: "+LocalDateTime.now());
    }
    @AroundLogger
    public void three() {
        logContainer.getMessages().add("three: "+LocalDateTime.now());
    }
}
