package com.thoughtworks.classAndStudent.repository.impl;

import com.thoughtworks.classAndStudent.domain.Class;
import com.thoughtworks.classAndStudent.repository.StudentRepository;
import com.thoughtworks.classAndStudent.repository.ClassStorage;
import com.thoughtworks.classAndStudent.repository.ClassRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.logging.Logger;


@Repository     ////加上这个注解， 可以不用configuration即可实现注入  这里需要方式实现类前面，实例化的， 不能放在其接口前面
public class ClassRepositoryImpl implements ClassRepository {
    StudentRepository studentRepository = new StudentRepositoryImpl();

    public ClassRepositoryImpl() {
        Logger.getLogger(this.getClass().getName()).info("12345678910");
    }

    @Override
    public Collection<Class> getClasses() {
        return ClassStorage.getClasses();
    }
}
