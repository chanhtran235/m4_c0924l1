package com.example.demo_spring_data_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("mess", "xin chào");
        System.out.println("----home finish------");
        return "home";
    }

}
