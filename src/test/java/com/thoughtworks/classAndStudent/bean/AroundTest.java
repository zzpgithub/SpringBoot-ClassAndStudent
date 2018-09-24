package com.thoughtworks.classAndStudent.bean;

import com.thoughtworks.classAndStudent.bean.Around.AroundCallMethod;
import com.thoughtworks.classAndStudent.bean.Around.AroundLogContainer;
import com.thoughtworks.classAndStudent.bean.Before.CallMethod;
import com.thoughtworks.classAndStudent.bean.Before.LogContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class  AroundTest{

    @Autowired
    private AroundCallMethod callMethod;

    @Autowired
    private AroundLogContainer logContainer;

    @BeforeEach
    void setUp(){
        logContainer.clear();
    }
    @Test
    void should_test_before_log_messages() {
        callMethod.callMethods();
        assertEquals(9, logContainer.getMessages().size());
        assertEquals("around before", logContainer.getMessages().get(0));
        assertEquals("around end", logContainer.getMessages().get(2));
        for(String str : logContainer.getMessages()){
            System.out.println(str);
        }
    }
}
