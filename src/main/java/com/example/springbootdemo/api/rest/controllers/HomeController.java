package com.example.springbootdemo.api.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, Afrika";
    }
}
