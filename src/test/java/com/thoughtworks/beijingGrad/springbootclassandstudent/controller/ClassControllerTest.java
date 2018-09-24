package com.thoughtworks.beijingGrad.springbootclassandstudent.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.beijingGrad.springbootclassandstudent.domain.Student;
import com.thoughtworks.beijingGrad.springbootclassandstudent.repository.StudentStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClassControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
       // mockMvc = standaloneSetup(new ClassController()).build();
    }

//    @Test
//    void should_throw_400_when_class_is_null() throws Exception {
//        ClassStorage.clear();
//        mockMvc.perform(get("/api/classes"))
//                .andExpect(status().is(400));
//    }

    @Test
    void should_return_all_the_classes() throws Exception {
        mockMvc.perform(get("/api/classes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].name").value("three class"))
                .andExpect(jsonPath("$[1].id").value(5))
                .andExpect(jsonPath("$[1].name").value("five class"));
    }

    @Test
    void should_add_a_student_for_class_3() throws Exception {
        Student student = new Student(2, "xiao", 20, 3);

        int originalStudentNumber = StudentStorage.getSTUDENTS().size();

        mockMvc.perform(post("/api/classes/3/students")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("xiao"))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.classId").value(3));

        int scaledStudentNumber = StudentStorage.getSTUDENTS().size();
        assertEquals(originalStudentNumber + 1,scaledStudentNumber);

        assertEquals(2, StudentStorage.getSTUDENTS().get(2).getId());
        assertEquals("xiao", StudentStorage.getSTUDENTS().get(2).getName());
        assertEquals(20, StudentStorage.getSTUDENTS().get(2).getAge());
    }

    @Test
    void should_get_the_students_for_class_5() throws Exception {
        mockMvc.perform(get("/api/classes/5/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].name").value("xiao li"))
                .andExpect(jsonPath("$[0].age").value(21))
                .andExpect(jsonPath("$[0].classId").value(5));

    }

    @Test
    void should_get_the_student_in_class_5_and_age_larger_20() throws Exception {
        mockMvc.perform(get("/api/classes/5/students?age=20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].name").value("xiao li"))
                .andExpect(jsonPath("$[0].age").value(21))
                .andExpect(jsonPath("$[0].classId").value(5));
    }
}
