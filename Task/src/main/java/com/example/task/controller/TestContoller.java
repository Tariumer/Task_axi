package com.example.task.controller;

import com.example.task.models.Peoples;
import com.example.task.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestContoller {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/requests")
    public @ResponseBody List<Peoples>
    test() {
         List lst = peopleService.peopleDao.findByPassport();
        System.out.println(lst.get(0));
        return lst;
    }
}
