package com.thoughtworks.beijingGrad.springbootclassandstudent.repository;

import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Class;

import java.util.Collection;

public interface ClassRepository {
    Collection<Class> getClasses();
}
