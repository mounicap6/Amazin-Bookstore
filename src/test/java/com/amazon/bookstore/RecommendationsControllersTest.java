package com.amazon.bookstore;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootTest
@AutoConfigureMockMvc
public class RecommendationsControllersTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void postRecommendations() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/addOrGetUser").param("name", "George")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("userBookstore"));
        mvc.perform(MockMvcRequestBuilders.post("/recommendation")
                .flashAttr("userID", "George")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("recommendation"));
    }
}