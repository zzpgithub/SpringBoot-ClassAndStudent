package com.thoughtworks.classAndStudent.bean.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Method {
    @Autowired
    LogContainer logContainer;
    @Logger
    public void one() {
        logContainer.getMessages().add("one: "+ LocalDateTime.now());
    }
    @Logger
    public void two() {
       logContainer.getMessages().add("two: "+LocalDateTime.now());
    }
    @Logger
    public void three() {
        logContainer.getMessages().add("three: "+LocalDateTime.now());
    }
}
