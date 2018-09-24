package com.thoughtworks.classAndStudent.bean.After;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AfterMethod {
    @Autowired
    AfterLogContainer logContainer;
    @AfterLogger
    public void one() {
        logContainer.getMessages().add("one: "+ LocalDateTime.now());
    }
    @AfterLogger
    public void two() {
        logContainer.getMessages().add("two: "+ LocalDateTime.now());
    }
    @AfterLogger
    public void three() {
        logContainer.getMessages().add("three: "+ LocalDateTime.now());
    }
}
