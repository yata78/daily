package com.example.daily;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dailyController {
    
    @PostMapping("/edit")
    public ModelAndView editEvent(ModelAndView mav){
        mav.setViewName("edit");
        return mav;
    }
}
