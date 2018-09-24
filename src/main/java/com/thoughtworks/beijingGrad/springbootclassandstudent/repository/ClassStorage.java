package com.thoughtworks.beijingGrad.springbootclassandstudent.repository;

import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Class;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClassStorage {
    private static final Map<Integer, Class> CLASSES = new HashMap<>();

    static {
        CLASSES.put(3, new Class(3, "three class"));

        CLASSES.put(5, new Class(5, "five class"));
    }

    public static Map<Integer, Class> getCLASSES() {
        return CLASSES;
    }

    public static Collection<Class> getClasses() {
        return CLASSES.values();
    }

    public static void clear(){
        CLASSES.clear();
    }
}
