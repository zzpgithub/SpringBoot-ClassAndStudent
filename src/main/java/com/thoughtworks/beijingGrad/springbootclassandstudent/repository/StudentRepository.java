package com.thoughtworks.beijingGrad.springbootclassandstudent.repository;

import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student add(Student student);

    Student getById(Integer id);

    Student addStudentForClass(int classId, Student student);

    List<Student> getStudentsByClassId(int classId);

    List<Student> getStudentsByClassIdAndAge(int classId, Integer minimumAge);
}
