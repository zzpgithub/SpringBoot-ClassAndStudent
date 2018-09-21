package com.thoughtworks.grad.springBoot.controller;

import com.thoughtworks.grad.springBoot.domain.Clazz;
import com.thoughtworks.grad.springBoot.domain.Student;
import com.thoughtworks.grad.springBoot.repository.ClazzRepository;
import com.thoughtworks.grad.springBoot.repository.Impl.ClazzRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.Collection;

@RestController
public class ClassController {

    private ClazzRepository clazzRepository = new ClazzRepositoryImpl();

    @GetMapping("/api/clazzes")
    public Collection<Clazz> queryClazzes(){
        return clazzRepository.findClazzByClazz();
    }

    @PostMapping("/api/clazzes/{clazzId}/students")
    ResponseEntity createStudentForClazz(@PathVariable int clazzId, @RequestBody Student student) {
        Clazz clazz = clazzRepository.addStudentByClazzId(clazzId, student);
        return new ResponseEntity<>(clazz, HttpStatus.CREATED);
    }

    @GetMapping("/api/clazzes/{clazzId}/students")
    public Clazz getStudentsOfClazz(@PathVariable int clazzId){
        return clazzRepository.getStudentsOfClazz(clazzId);
    }

    @GetMapping("/api/clazzes/{clazzId}/students/{age}")
    public Clazz getStudentsAgeMoreThan20InClazz(@PathVariable int clazzId, @PathVariable int age){
        return clazzRepository.getStudentsAgeMoreThan20InClazz(clazzId, age);
    }

//    @GetMapping(value = "/api/clazzes/{clazzId}/students", params = "age")
//    public Clazz getStudentsAgeMoreThan20InClazz(@PathVariable int clazzId, @PathVariable int age){
//        return clazzRepository.getStudentsAgeMoreThan20InClazz(clazzId, age);
//    }
}
