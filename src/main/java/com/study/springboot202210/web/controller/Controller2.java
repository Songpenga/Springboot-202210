package com.study.springboot202210.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {

    @GetMapping("/controller/2")
    public String load(Model model){
        model.addAttribute("name", "peng");

        return "controller_test";
    }
}
