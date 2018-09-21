package com.thoughtworks.grad.springBoot.repository;

import com.thoughtworks.grad.springBoot.domain.Clazz;
import com.thoughtworks.grad.springBoot.domain.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ClazzStorage {
    private static final Map<Integer, Clazz> CLAZZES = new HashMap<>();

    static {
        Student studentOne = new Student(1, "xiao hong", 15);
        ArrayList<Student> studentsOne = new ArrayList<>();
        studentsOne.add(studentOne);
        CLAZZES.put(1, new Clazz(1, "clazzOne", studentsOne));

        Student studentTwo = new Student(2, "xiao ming", 15);
        ArrayList<Student> studentsTwo = new ArrayList<>();
        studentsTwo.add(studentTwo);
        CLAZZES.put(2, new Clazz(2, "clazzTwo", studentsTwo));

        Student studentThree = new Student(3, "xiao hua", 15);
        ArrayList<Student> studentsThree = new ArrayList<>();
        studentsThree.add(studentThree);
        CLAZZES.put(3, new Clazz(3, "clazzThree", studentsThree));

        Student student5 = new Student(5, "xiao fang", 15);
        Student studentTwo5 = new Student(6, "xiao li", 23);
        ArrayList<Student> students5 = new ArrayList<>();
        students5.add(student5);
        students5.add(studentTwo5);
        CLAZZES.put(5, new Clazz(5, "clazzFive", students5));
    }

    public static void addClazzes(Clazz ... clazzes){
        Arrays.stream(clazzes).forEach( clazz -> {
            CLAZZES.put(clazz.getId(), clazz);
        });
    }

    public static Collection<Clazz> findClazzByClazz() {
        return CLAZZES.values();
    }

    public static Clazz addStudentByClazzId(int clazzId, Student student) {
        CLAZZES.get(clazzId).getStudents().add(student);
        return CLAZZES.get(clazzId);
    }

    public static Clazz getStudentsOfClazz(int clazzId) {
        return CLAZZES.get(clazzId);
    }

    public static Clazz getStudentsAgeMoreThan20InClazz(int clazzId, int age) {
        List<Student> result = null;
        result = CLAZZES.get(clazzId).getStudents().stream().filter( student -> student.getAge() > 20).collect(Collectors.toList());
        CLAZZES.get(clazzId).setStudents(result);
        return CLAZZES.get(clazzId);
    }
}
