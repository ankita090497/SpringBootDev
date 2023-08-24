package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/info")
    public String infoPage(Model model) {

        //Putting data in model
        model.addAttribute("name", "Ankita Patel");
        model.addAttribute("currentDate", new Date().toLocaleString());

        return "infopage"; //infopage.html

    }
}
