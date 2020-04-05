package com.example.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;

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
    public void test3() throws Exception {
        ResultActions result = mockMvc.perform(post("/eventss")
                    .param("name", "ewan")
                    .param("age", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
                //.andExpect(jsonPath("name").value("ewan"));

        ModelAndView mav = result.andReturn().getModelAndView();
        Map<String, Object> model = mav.getModel();
        System.out.println(model);
    }

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
