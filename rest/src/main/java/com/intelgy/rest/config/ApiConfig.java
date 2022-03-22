package com.intelgy.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ApiConfig {

    @Value("${api}")
    private String api;

    @Bean
    public RestTemplate restTemplate(){
        DefaultUriBuilderFactory defaultUri = new DefaultUriBuilderFactory(api);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(defaultUri);
        return restTemplate;
    }
}

