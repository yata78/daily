package com.example.daily;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/move")
    public String hello(@RequestParam String name,@RequestParam String email, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "hello";
    }


}
