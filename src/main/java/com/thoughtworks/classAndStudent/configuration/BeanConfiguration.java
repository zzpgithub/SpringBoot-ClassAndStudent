package com.thoughtworks.classAndStudent.configuration;


import org.springframework.context.annotation.Configuration;

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
