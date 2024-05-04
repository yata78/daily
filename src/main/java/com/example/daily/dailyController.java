package com.example.daily;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dailyController {
    
    @Autowired
    dailyEvRepository repository;
    
    @RequestMapping(value = "/edit" , method = RequestMethod.GET)
    public ModelAndView editEvent(ModelAndView mav, @RequestParam("id") Long id){
        mav.setViewName("edit");
        Optional<dailyEv> dailyEvData = repository.findByIdCustom(id); 
        mav.addObject("data", dailyEvData);
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createEvent(@ModelAttribute("dailyEv") dailyEv Ev, ModelAndView mav){
        final LocalDate currentDate = LocalDate.now();
        Ev.setEventDate(currentDate);
        mav.setViewName("hello");
        repository.save(Ev);
        Iterable<dailyEv> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }

}
