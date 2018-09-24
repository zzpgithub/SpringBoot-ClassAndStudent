package com.thoughtworks.beijingGrad.springbootclassandstudent.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeanConfigurationTest {

    @Test
    void should_eager_load_bean() {
        // ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBootApplication.class);
        // ClassRepository classRepository = applicationContext.getBean(ClassRepository.class);
    }
}
