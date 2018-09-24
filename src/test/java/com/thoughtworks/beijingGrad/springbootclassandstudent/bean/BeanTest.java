package com.thoughtworks.beijingGrad.springbootclassandstudent.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeanTest {

    @Autowired
    private CallMethod callMethod;

    @Autowired
    private LogContainer logContainer;

    @Test
    void should_test_log_messages() {
        callMethod.callMethods();

        assertEquals(3, logContainer.getMessages().size());

        for(String str : logContainer.getMessages()){
            System.out.println(str);
        }
    }

}
