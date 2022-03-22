package com.intelgy.rest.service.impl;

import com.intelgy.rest.model.User;
import com.intelgy.rest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void service() {
        List<User> data = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setLastName("Bluth");
        user.setEmail("george.bluth@reqres.in");
        data.add(user);

        List<User> users = userService.findAll();
        assertEquals(users.get(0), data.get(0));
    }

}