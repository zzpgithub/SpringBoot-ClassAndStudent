package com.thoughtworks.beijingGrad.springbootclassandstudent.controller;

import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Class;
import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Student;
import com.thoughtworks.beijingGrad.springbootclassandstudent.repository.ClassRepository;
import com.thoughtworks.beijingGrad.springbootclassandstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class ClassController {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/api/classes")
    public ResponseEntity<?> getClasses(){
        Collection<Class> classes = classRepository.getClasses();
        if(classes.isEmpty()){
            return ResponseEntity.status(400).body(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @PostMapping("/api/classes/{classId}/students")
    public ResponseEntity<?> addStudentForClass(@PathVariable int classId, @RequestBody Student student){
        return new ResponseEntity<>(studentRepository.addStudentForClass(classId, student), HttpStatus.CREATED);
    }

    @GetMapping("/api/classes/{classId}/students")
    public ResponseEntity<?> getStudentsByClassIdAndAge(@PathVariable int classId,
                                                        @RequestParam(name = "age", required = false) Integer age){
        if(age == null){
            return new ResponseEntity<>(studentRepository.getStudentsByClassId(classId), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentRepository.getStudentsByClassIdAndAge(classId, age), HttpStatus.OK);
    }
}
