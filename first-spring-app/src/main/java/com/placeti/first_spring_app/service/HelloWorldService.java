package com.placeti.first_spring_app.service;

import org.springframework.stereotype.Service;

// contem as regras de negocio
@Service
public class HelloWorldService {
    public String helloWorld(String name) {
        return "Hello World " + name;
    }
}
