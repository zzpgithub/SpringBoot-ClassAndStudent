package com.thoughtworks.classAndStudent.bean;

import com.thoughtworks.classAndStudent.bean.After.AfterCallMethod;
import com.thoughtworks.classAndStudent.bean.After.AfterLogContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.verification.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AfterTest {

    @Autowired
    private AfterCallMethod callMethod;

    @Autowired
    private AfterLogContainer logContainer;

    @BeforeEach
    void setUp(){
        logContainer.clear();
    }
    @Test
    void should_test_after_log_messages() {
        callMethod.callMethods();
        assertEquals(6, logContainer.getMessages().size());
        assertEquals("after", logContainer.getMessages().get(1));
        for(String str : logContainer.getMessages()){
            System.out.println(str);
        }
    }
}
