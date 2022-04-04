package com.example.task.controller;

import com.example.task.Peoples;
import com.example.task.repos.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import com.example.task.repos.PeopleRepo;

@Controller
public class HelloWorldController {
    @Autowired
    private PeopleRepo peopleRepo;
    @RequestMapping(value = "/greeting")
    public String helloWorldController(Model model) {
        model.addAttribute("name", "Dimon");
        return "greeting";
    }
    @GetMapping
    public String index(Map<String,Object> model){
        Iterable<Peoples> peoples = peopleRepo.findAll();
        model.put("peoples",peoples);
        return "index";
    }

    @PostMapping
    public String add(@RequestParam String name,@RequestParam String surname,@RequestParam String mid_name,Map<String,Object> model){
        Peoples people= new Peoples(name,surname,mid_name);
        peopleRepo.save(people);
        Iterable<Peoples> peoples = peopleRepo.findAll();
        model.put("peoples",peoples);
        return "index";
    }
}
