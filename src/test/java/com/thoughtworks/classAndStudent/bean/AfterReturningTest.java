package com.thoughtworks.classAndStudent.bean;

import com.thoughtworks.classAndStudent.bean.AfterReturning.AfterReturningCallMethod;
import com.thoughtworks.classAndStudent.bean.AfterReturning.AfterReturningLogContainer;
import com.thoughtworks.classAndStudent.bean.AfterThrowing.AfterThrowingCallMethod;
import com.thoughtworks.classAndStudent.bean.AfterThrowing.AfterThrowingLogContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AfterReturningTest {

    @Autowired
    private AfterReturningCallMethod callMethod;

    @Autowired
    private AfterReturningLogContainer logContainer;

    @BeforeEach
    void setUp(){
        logContainer.clear();
    }
    @Test
    void should_test_after_log_messages() {
        try {
            callMethod.callMethods();
        } catch (Exception e) {
        }
        assertEquals("afterReturning", logContainer.getMessages().get(1));
        for(String str : logContainer.getMessages()){
            System.out.println(str);
        }
    }
}
