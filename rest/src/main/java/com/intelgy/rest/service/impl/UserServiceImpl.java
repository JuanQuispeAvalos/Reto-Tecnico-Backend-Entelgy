package com.intelgy.rest.service.impl;

import com.intelgy.rest.model.User;
import com.intelgy.rest.model.UserResponse;
import com.intelgy.rest.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> findAll() {
        UserResponse response = restTemplate.getForObject("users", UserResponse.class);

        if (response != null) return response.getData();
        else return new ArrayList<>();

    }

}
