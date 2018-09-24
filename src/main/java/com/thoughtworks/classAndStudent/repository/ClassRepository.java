package com.thoughtworks.classAndStudent.repository;

import com.thoughtworks.classAndStudent.domain.Class;

import java.util.Collection;

public interface ClassRepository {
    Collection<Class> getClasses();
}
