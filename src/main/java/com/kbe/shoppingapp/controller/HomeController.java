package com.kbe.shoppingapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class HomeController {

    
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}