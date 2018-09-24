package com.thoughtworks.beijingGrad.springbootclassandstudent.bean;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogContainer {
    private List<String> messages = new ArrayList<>();

    public List<String> getMessages() {
        return messages;
    }
}
