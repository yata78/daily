package com.example.daily;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @Autowired
    dailyEvRepository repository;
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/move")
    public ModelAndView hello(ModelAndView mav) {
        mav.setViewName("hello");
        Iterable<dailyEv> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }


}
