package com.example.daily;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;

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

    @RequestMapping(value = "/edit" , method = RequestMethod.POST)
    public ModelAndView editEvent(ModelAndView mav, @ModelAttribute("dailyEv") dailyEv Ev) {
        repository.saveAndFlush(Ev);
        Iterable<dailyEv> list = repository.findByIdAscData();
        mav.addObject("data", list);
        mav.setViewName("hello");
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createEvent(@ModelAttribute("dailyEv") dailyEv Ev, ModelAndView mav){
        final LocalDate currentDate = LocalDate.now();
        Ev.setEventDate(currentDate);
        mav.setViewName("hello");
        repository.save(Ev);
        Iterable<dailyEv> list = repository.findByIdAscData();
        mav.addObject("data", list);
        return mav;
    }

}
