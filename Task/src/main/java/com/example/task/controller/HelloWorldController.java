package com.example.task.controller;

import com.example.task.Peoples;
import com.example.task.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class HelloWorldController {

    PeopleService peopleService=new PeopleService();

    @GetMapping(value = "/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/displayAll")
    public String display(Model model){
        List<Peoples> peopleinfos = peopleService.findAllPeoples();
        model.addAttribute("peopleinfos" ,peopleinfos);
        return "displayAll";
    }

    @GetMapping(value = "/add")
    public String hello(Model model) {
        return "add";
    }

    @GetMapping(value = "/accepting")
    public String rnd(Model model){
        return "/accepting";
    }
    @GetMapping(value = "/declaining")
    public String tt(Model model){
        return "/declaining";
    }


    @PostMapping(value = "/add")
    public RedirectView add(@RequestParam String name,
                      @RequestParam String surname,
                      @RequestParam String mid_name,
                      @RequestParam String passport,
                      @RequestParam String family_status,
                      @RequestParam String address,
                      @RequestParam String number,
                      @RequestParam String organization,
                      @RequestParam String post,
                      @RequestParam Integer work_time,
                      @RequestParam Integer credit_sum,
                      Map<String,Object> model){
        Peoples people= new Peoples(name,surname,mid_name,passport,family_status,address,number,organization,post,work_time,credit_sum);
        peopleService.savePeople(people);
        // сделать редтрект
        Random random=new Random();
        if(random.nextInt(2)==0) {
            return new RedirectView("declaining");
        }
        else
        return new RedirectView("accepting");
    }
}
