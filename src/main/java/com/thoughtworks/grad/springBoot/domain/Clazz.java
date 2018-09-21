package com.thoughtworks.grad.springBoot.domain;

import java.util.List;

public class Clazz {
    private int id;
    private String name;
    private List<Student> students;

    public Clazz() {
    }

    public Clazz(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
