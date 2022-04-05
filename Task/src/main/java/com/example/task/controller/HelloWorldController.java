package com.example.task.controller;

import com.example.task.Peoples;
import com.example.task.dao.PeopleDao;
import com.example.task.repos.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HelloWorldController {

    PeopleDao peopledao=new PeopleDao();
    @RequestMapping(value = "/greeting")
    public String helloWorldController(Model model) {
        model.addAttribute("name", "Dimon");
        return "greeting";
    }
    @GetMapping
    public String index(Model model){
        // получение всех пользователей
        // добавить пользователей в modelmap или что то такое в thymeleaf

        return "index";
    }

//    @PostMapping(value = "/index")
    @RequestMapping(method= RequestMethod.POST)
    public String add(@RequestParam String name,@RequestParam String surname,@RequestParam String mid_name,Map<String,Object> model){
        Peoples people= new Peoples(name,surname,mid_name);
        peopledao.save(people);
        return "index";
    }
}
