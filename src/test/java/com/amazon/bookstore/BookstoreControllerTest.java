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

@SpringBootTest
@AutoConfigureMockMvc
public class BookstoreControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHomePage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"));

    }

    @Test
    public void getUserHomePage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user_homepage").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("userBookstore"));

    }

    @Test
    public void getOwnerHomePage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/owner_homepage").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("ownerBookstore"));

    }

    @Test
    public void postMainPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/bookstore").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("ownerBookstore"));

    }

    @Test
    public void postUploadBookstore() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/editBookstore").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("editBookstore"));

    }

    @Test
    public void postCreateBook() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/uploadBook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("editBookstore"));

    }

    @Test
    public void postAddToCart() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/shoppingcart").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("userBookstore"));

    }

    @Test
    public void postAddOrGetUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/addOrGetUser").param("name", "George")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("userBookstore"));

    }

    @Test
    public void postSearchForBook() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/search").param("keyword", "Thriller")
                .param("category", "Genre")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("userBookstore"));

    }

    @Test
    public void getDeleteBook() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/delete/{isbn}", "123456")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("ownerBookstore"));

    }
}