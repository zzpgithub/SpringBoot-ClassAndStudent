package com.thoughtworks.beijingGrad.springbootclassandstudent.configuration;


import com.thoughtworks.beijingGrad.springbootclassandstudent.repository.ClassRepository;
import com.thoughtworks.beijingGrad.springbootclassandstudent.repository.impl.ClassRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {

    //@Bean
   // @Lazy
 //   @Primary
//    public ClassRepository createClassRepository(){
//        return new ClassRepositoryImpl();
//    }

//    @Bean    这样报错， 提示有两个bean，   是根据返回值类型注入的.   为了防止这样的错误， 可以用@Primary注解
//    public ClassRepository createSQLClassRepository(){
//        return new ClassSQLRepositoryImpl();
//    }

//    @Bean
//    public ClassRepository createSQLClassRepository(){
//        return new ClassSQLRepositoryImpl();
//    }
}
