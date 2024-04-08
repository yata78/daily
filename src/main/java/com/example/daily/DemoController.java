package com.example.daily;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/move")
    public String hello() {
        return "hello";
    }


}
