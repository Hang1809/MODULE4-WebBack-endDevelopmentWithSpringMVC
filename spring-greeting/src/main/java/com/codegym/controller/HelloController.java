package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {

    @GetMapping("/hello")
//    @ResponseBody
    public String greeting (@RequestParam String message){
        return message;
//        http://localhost:8080/hello?name=MynameisHang
//        http://localhost:8080/hello?message=Helloooooooooooo

//        @RestController = @Controller + @ResponseBody
    }
}
