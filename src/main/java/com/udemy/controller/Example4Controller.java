package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

    @GetMapping("/hello")
    public String index(){
            return "404";
    }

    @GetMapping("/hola")
    public String error500(){
        return "500";
    }

}
