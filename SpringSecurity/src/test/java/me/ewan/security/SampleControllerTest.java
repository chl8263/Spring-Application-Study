package me.ewan.security;

import me.ewan.security.account.Account;
import me.ewan.security.form.SampleController;
import me.ewan.security.form.SampleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    SampleService sampleService;

    @Test
    public void AsyncServiceTest() throws Exception {

        //Given
        Account account = Account.builder()
                .username("ewan")
                .password("123")
                .role("USER")
                .build();


        mockMvc.perform(get("/async-service"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
