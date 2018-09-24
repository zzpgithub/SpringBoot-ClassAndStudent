package com.thoughtworks.classAndStudent.bean.AfterThrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AfterThrowingMethod {
    @Autowired
    AfterThrowingLogContainer logContainer;
    @AfterThrowingLogger
    public void one() {
        logContainer.getMessages().add("one: "+ LocalDateTime.now());
    }
    @AfterThrowingLogger
    public void two() throws IllegalStateException{
        logContainer.getMessages().add("two: "+ LocalDateTime.now());
        throw new IllegalStateException();
    }
    @AfterThrowingLogger
    public void three() {
        logContainer.getMessages().add("three: "+ LocalDateTime.now());
    }
}
