package com.example.springmvcprinciple;

import com.example.springmvcprinciple.domain.Person;
import com.example.springmvcprinciple.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void hello() throws Exception {
//        this.mockMvc.perform(get("/hello").param("name", "ewan"))
//                .andDo(print())
//                .andExpect(content().string("hello ewan"));

        Person person = new Person();
        person.setName("ewan");
        Person savedPerson = personRepository.save(person);

        this.mockMvc.perform(get("/hello").param("id", savedPerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello ewan"));
    }

    @Test
    public void helloStatic() throws Exception {

        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello index")));
    }

    @Test
    public void helloMobile() throws Exception {

        this.mockMvc.perform(get("/mobile/mobile.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello mobile")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }

    @Test
    public void stringMessage() throws Exception{
        this.mockMvc.perform(get("/message").content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello person"));
    }

    @Test
    public void jsonMessageTest() throws Exception{

        Person person = new Person();
        person.setId(2019L);
        person.setName("ewan");

        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(person)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}