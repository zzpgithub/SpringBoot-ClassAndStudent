package com.thoughtworks.beijingGrad.springbootclassandstudent.repository;

import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class StudentStorage {
    private static final Map<Integer, Student> STUDENTS = new HashMap<>();

    static {
        STUDENTS.put(1, new Student(1, "xiao hong", 18, 3));
        STUDENTS.put(3, new Student(3, "xiao li", 21, 5));
    }

    public static Map<Integer, Student> getSTUDENTS() {
        return STUDENTS;
    }

    public static Student add(Student student) {
        STUDENTS.put(student.getId(), student);
        return student;
    }

    public static Student getById(int id){
        return STUDENTS.get(id);
    }

    public static Student addForClass(int classId, Student student) {
        STUDENTS.put(student.getId(), student);
        return student;
    }

    public static List<Student> getStudentsByClassId(int classId) {
        return STUDENTS.values().stream()
                .filter(student -> student.getClassId() == classId)
                .collect(toList());
    }
}
