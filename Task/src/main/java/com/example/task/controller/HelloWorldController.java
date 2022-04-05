package com.example.task.controller;

import com.example.task.Peoples;
import com.example.task.service.PeopleService;
import com.example.task.repos.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class HelloWorldController {

    PeopleService peopleService=new PeopleService();
    @RequestMapping(value = "/greeting")
    public String helloWorldController(Model model) {
        model.addAttribute("name", "Dimon");
        return "greeting";
    }
    @GetMapping(value = "/index")
    public String index(Model model){
        List<Peoples> peopleinfos = peopleService.findAllPeoples();
        // добавить пользователей в modelmap или что то такое в thymeleaf
        model.addAttribute("peopleinfos" ,peopleinfos);
        return "index";
    }
    @GetMapping(value = "/add")
    public String hello(Model model) {
        return "/add";
    }
    @PostMapping(value = "/add")
    public String add(@RequestParam String name,@RequestParam String surname,@RequestParam String mid_name,Map<String,Object> model){
        Peoples people= new Peoples(name,surname,mid_name);
        peopleService.savePeople(people);
        // сделать редтрект
        return "/index.html";
    }
}
