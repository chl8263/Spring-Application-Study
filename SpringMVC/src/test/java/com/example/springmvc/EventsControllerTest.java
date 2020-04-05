package com.example.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test2() throws Exception {
        mockMvc.perform(post("/event?name=ewan"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("ewan"));
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/templates/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
