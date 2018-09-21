package com.thoughtworks.grad.springBoot.repository.Impl;

import com.thoughtworks.grad.springBoot.domain.Clazz;
import com.thoughtworks.grad.springBoot.domain.Student;
import com.thoughtworks.grad.springBoot.repository.ClazzRepository;
import com.thoughtworks.grad.springBoot.repository.ClazzStorage;

import java.util.Collection;

public class ClazzRepositoryImpl implements ClazzRepository {
    @Override
    public Collection<Clazz> findClazzByClazz() {
        return ClazzStorage.findClazzByClazz();
    }

    @Override
    public Clazz addStudentByClazzId(int clazzId, Student student) {
        return ClazzStorage.addStudentByClazzId(clazzId, student);
    }

    @Override
    public Clazz getStudentsOfClazz(int clazzId) {
        return ClazzStorage.getStudentsOfClazz(clazzId);
    }

    @Override
    public Clazz getStudentsAgeMoreThan20InClazz(int clazzId, int age) {
        return ClazzStorage.getStudentsAgeMoreThan20InClazz(clazzId, age);
    }
}
