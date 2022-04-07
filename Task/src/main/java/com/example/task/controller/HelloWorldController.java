package com.example.task.controller;

import com.example.task.Credit_requests;
import com.example.task.Peoples;
import com.example.task.dao.Credit_requestsDao;
import com.example.task.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class HelloWorldController {

    PeopleService peopleService=new PeopleService();
    Credit_requestsDao credit_requestsDao=new Credit_requestsDao();

    @GetMapping(value = "/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/displayAll")
    public String display(Model model){
        List<Peoples> peopleinfos = peopleService.findAllPeoples();
        List<Credit_requests> credit_requests=credit_requestsDao.findAll();
        model.addAttribute("peopleinfos" ,peopleinfos);
        model.addAttribute("credit_requests" ,credit_requests);
        return "displayAll";
    }

    @GetMapping(value = "/add")
    public String hello(Model model) {
        return "add";
    }

    @GetMapping(value = "/accepting")
    public String accept(@RequestParam Integer id, Model model){
        Peoples people = peopleService.findPeople(id);
        model.addAttribute("peopleinfo",people);
        Credit_requests credit_request=people.getCredit_requests();
        model.addAttribute("credit_request",credit_request);
        Date currDate=new Date();
        model.addAttribute("date",currDate);
        return "/accepting";
    }
    @GetMapping(value = "/declaining")
    public String tt(Model model){
        return "/declaining";
    }

    @GetMapping(value = "/accept")
    public String accept(@RequestParam() Integer id){
        System.out.print("Done");
        return "/accept";
    }

    @PostMapping(value = "/accept")
    public String accep(@RequestParam Peoples people){
        System.out.print("Done");
//        System.out.println(id);
        return "/accept";
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
        Random random=new Random();
        if(!random.nextBoolean()) {
            Credit_requests request1 = new Credit_requests(false);
            credit_requestsDao.save(request1);
            people.setCredit_requests(request1);
            peopleService.updatePeople(people);
            return new RedirectView("declaining");
        }
        else {
            Integer time=random.nextInt(12)+1;
            Integer requested_credit=random.nextInt(credit_sum/2)+credit_sum/2;
            Credit_requests request2 = new Credit_requests(true,time,requested_credit,false);
            credit_requestsDao.save(request2);
            people.setCredit_requests(request2);
            peopleService.updatePeople(people);
            return new RedirectView("accepting/?id="+people.getId());
        }
    }
}
