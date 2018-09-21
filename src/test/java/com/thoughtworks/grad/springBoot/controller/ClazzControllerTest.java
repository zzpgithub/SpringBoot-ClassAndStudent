package com.thoughtworks.grad.springBoot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.grad.springBoot.domain.Student;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ClazzControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = standaloneSetup(new ClassController()).build();
    }

    @Test
    void should_get_classes() throws Exception {
        mockMvc.perform(get("/api/clazzes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("clazzOne"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("clazzTwo"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("clazzThree"));;
    }

    @Test
    void should_create_student_for_clazzThree() throws Exception {
        Student student = new Student(4, "xiao qu", 23);
        mockMvc.perform(post("/api/clazzes/3/students")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.students", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.students", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.students[1].name").value("xiao qu"));
    }

    @Test
    void should_get_students_of_clazz_5() throws Exception {
        mockMvc.perform(get("/api/clazzes/5/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.students", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.students[0].name").value("xiao fang"))
                .andExpect(jsonPath("$.students[1].name").value("xiao li"));
    }

    @Test
    void should_get_student_age_more_than_20_in_clazz_5() throws Exception {
        mockMvc.perform(get("/api/clazzes/5/students/20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.students", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.students[0].name").value("xiao li"));
    }

//    @Test
//    void should_get_student_age_more_than_20_in_clazz_5() throws Exception {
//        mockMvc.perform(get("/api/clazzes/5/students").param("age", "20"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.students", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$.students[0].name").value("xiao li"));
//    }
}
