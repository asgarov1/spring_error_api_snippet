package com.asgarov.api.response.controller.advice;

import com.asgarov.api.response.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ArticleExceptionHandlerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyService myService;

    @Test
    public void articleNotFound() throws Exception {
        when(myService.getArticle()).thenReturn("test");

        mvc.perform(get("http://localhost:8080/articles/1234"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("ARTICLE_NOT_FOUND"))
                .andExpect(jsonPath("$.message").value("No article with id 1234 found"));
    }

}