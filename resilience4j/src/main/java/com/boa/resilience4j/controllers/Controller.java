package com.boa.resilience4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.resilience4j.services.Service;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String getValues() {
        return service.fetchData();
    }
}
