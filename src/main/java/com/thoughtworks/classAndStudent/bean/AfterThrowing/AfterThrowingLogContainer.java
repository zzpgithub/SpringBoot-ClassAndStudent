package com.thoughtworks.classAndStudent.bean.AfterThrowing;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AfterThrowingLogContainer {
    private List<String> messages = new ArrayList<>();

    public List<String> getMessages() {
        return messages;
    }

    public void clear() {
        messages.clear();
    }
}
