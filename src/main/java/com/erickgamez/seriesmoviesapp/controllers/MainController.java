package com.erickgamez.seriesmoviesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"/", "/home", "/index"})
    public String create(){
        return "index";
    }
}
