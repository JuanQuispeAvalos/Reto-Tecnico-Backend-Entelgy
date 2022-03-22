package com.intelgy.rest.controller;


import com.intelgy.rest.model.User;
import com.intelgy.rest.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    private final UserService service;

    public Controller(UserService service) {
        this.service = service;
    }


    @PostMapping
    public List<User> list() {
        System.out.println(service.findAll());
        return service.findAll();
    }
}

