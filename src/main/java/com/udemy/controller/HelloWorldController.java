package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/say")
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "helloworld";
    }
}
