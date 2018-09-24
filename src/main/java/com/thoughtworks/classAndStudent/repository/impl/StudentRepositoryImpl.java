package com.thoughtworks.classAndStudent.repository.impl;

import com.thoughtworks.classAndStudent.domain.Student;
import com.thoughtworks.classAndStudent.repository.StudentRepository;
import com.thoughtworks.classAndStudent.repository.StudentStorage;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public Student add(Student student) {
        return StudentStorage.add(student);
    }

    @Override
    public Student getById(Integer id) {
        return StudentStorage.getById(id);
    }

    @Override
    public Student addStudentForClass(int classId, Student student) {
        return StudentStorage.addForClass(classId, student);
    }

    @Override
    public List<Student> getStudentsByClassId(int classId) {
        return StudentStorage.getStudentsByClassId(classId);
    }

    @Override
    public List<Student> getStudentsByClassIdAndAge(int classId, Integer age) {
        return StudentStorage.getStudentsByClassId(classId).stream()
                .filter(student -> student.getAge() > age)
                .collect(toList());
    }
}
