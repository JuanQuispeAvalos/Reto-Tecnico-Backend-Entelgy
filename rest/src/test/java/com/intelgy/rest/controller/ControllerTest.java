package com.intelgy.rest.controller;

import com.intelgy.rest.model.User;
import com.intelgy.rest.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @Test
    void list() throws Exception {

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setEmail("test@hotmail.com");
        user1.setId(1);
        user1.setLastName("Test");
        users.add(user1);
        given(service.findAll()).willReturn(users);
        mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isArray());

    }
}