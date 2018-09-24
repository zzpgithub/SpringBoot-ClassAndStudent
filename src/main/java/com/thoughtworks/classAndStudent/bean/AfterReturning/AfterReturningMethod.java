package com.thoughtworks.classAndStudent.bean.AfterReturning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AfterReturningMethod {
    @Autowired
    AfterReturningLogContainer logContainer;
    @AfterReturningLogger
    public void one() {
        logContainer.getMessages().add("one: "+ LocalDateTime.now());
    }
    @AfterReturningLogger
    public void two() throws IllegalStateException{
        logContainer.getMessages().add("two: "+ LocalDateTime.now());
        throw new IllegalStateException();
    }
    @AfterReturningLogger
    public void three() {
        logContainer.getMessages().add("three: "+ LocalDateTime.now());
    }
}
