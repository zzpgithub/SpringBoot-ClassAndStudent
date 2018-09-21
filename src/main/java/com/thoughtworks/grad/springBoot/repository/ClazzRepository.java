package com.thoughtworks.grad.springBoot.repository;

import com.thoughtworks.grad.springBoot.domain.Clazz;
import com.thoughtworks.grad.springBoot.domain.Student;

import java.util.Collection;

public interface ClazzRepository {

    Collection<Clazz> findClazzByClazz();

    Clazz addStudentByClazzId(int clazzId, Student student);

    Clazz getStudentsOfClazz(int clazzId);

    Clazz getStudentsAgeMoreThan20InClazz(int clazzId, int age);
}
