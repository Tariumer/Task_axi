package com.example.task.controller;

import com.example.task.models.Peoples;
import com.example.task.dao.CreditRequestsDao;
import com.example.task.models.CreditRequests;
import com.example.task.service.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
public class HelloWorldController {

    PeopleService peopleService = new PeopleService();
    CreditRequestsDao CreditRequestsDao = new CreditRequestsDao();

    @GetMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping(value = "/creditRequests")
    public String displayRequests(Model model) {
        List<Peoples> peopleinfos = peopleService.findAllPeoples();
        List<CreditRequests> CreditRequests = CreditRequestsDao.findAll();
        model.addAttribute("peopleinfos", peopleinfos);
        model.addAttribute("CreditRequests", CreditRequests);
        return "/creditRequests";
    }

    @GetMapping(value = "/displayAll")
    public String displayPeople(Model model) {
        List<Peoples> peopleinfos = peopleService.findPeoplePass();
        model.addAttribute("peopleinfos", peopleinfos);
        return "/displayAll";
    }

    @GetMapping(value = "/add")
    public String hello(Model model) {
        return "add";
    }

    @GetMapping(value = "/search")
    public String searchPeoples(Model model) {
        return "/search";
    }

    @PostMapping(value = "/searchResult")
    public String searchResult(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String mid_name,
                               @RequestParam String number,
                               @RequestParam String passport, RedirectAttributes attributes,
                               Model model) {
        List<Peoples> peopleinfos;
        if (!name.equals("") && !surname.equals("") && !mid_name.equals("") && !passport.equals("") && !number.equals("")) {
            peopleinfos = peopleService.findByAllParam(name, surname, mid_name, number, passport);
        } else if (!name.equals("") && !surname.equals("") && !mid_name.equals("")) {
            peopleinfos = peopleService.findPeopleByFIO(name, surname, mid_name);
        } else if (!passport.equals("")) {
            peopleinfos = peopleService.findPeopleByPassport(passport);
        } else if (!number.equals("")) {
            peopleinfos = peopleService.findPeopleByPhone(number);
        } else {
            return "redirect:/searchError";
        }
        if (peopleinfos.size() == 0) {
            return "redirect:/search";
        }
        model.addAttribute("peopleinfos", peopleinfos);
        return ("/searchResult");
    }

//    @GetMapping(value = "/searchResult")
//    public String searchRes(Model model) {
//        return "/searchError";
//    }

    @GetMapping(value = "/searchError")
    public String searchError() {
        return "/searchError";
    }

    @GetMapping(value = "/accepting")
    public String accept(@RequestParam Integer id, Model model) {
        Peoples people = peopleService.findPeople(id);
        model.addAttribute("peopleinfo", people);
        CreditRequests credit_request = people.getCreditRequests();
        model.addAttribute("credit_request", credit_request);
        Date currDate = new Date();
        model.addAttribute("date", currDate);
        return "/accepting";
    }

    @GetMapping(value = "/declaining")
    public String tt(Model model) {
        return "/declaining";
    }

    @GetMapping(value = "/displayAllContracts")
    public String dis(Model model) {
        List<Peoples> peopleinfos = peopleService.findAllPeoples();
        List<Peoples> rezultPeoples = new ArrayList<>();
        for (Integer i = 0; i < peopleinfos.size(); i++) {
            if (peopleinfos.get(i).getCreditRequests().getDecision()) {
                rezultPeoples.add(peopleinfos.get(i));
            }
        }
        model.addAttribute("peopleinfos", rezultPeoples);
        return "/displayAllContracts";
    }

    @GetMapping(value = "/accept")
    public String acceptss(@RequestParam Integer id, Model model) {
        System.out.print(id);
        System.out.print("Done");
        return "/accept";
    }

    @PostMapping(value = "/accepting")
    public RedirectView accep(@RequestParam Integer id, Model model) {
        Peoples people = peopleService.findPeople(id);
        CreditRequests credit_request = people.getCreditRequests();
        credit_request.setStatus(true);
        Date date = new Date();
        credit_request.setDate(date);
        CreditRequestsDao.update(credit_request);
        return new RedirectView("index");
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
                            Map<String, Object> model) {
        Peoples people = new Peoples(name, surname, mid_name, passport, family_status, address, number, organization, post, work_time, credit_sum);
        peopleService.savePeople(people);
        Random random = new Random();
        if (!random.nextBoolean()) {
            CreditRequests request1 = new CreditRequests(false);
            CreditRequestsDao.save(request1);
            people.setCreditRequests(request1);
            peopleService.updatePeople(people);
            return new RedirectView("declaining");
        } else {
            Integer time = random.nextInt(12) + 1;
            Integer requested_credit = random.nextInt(credit_sum / 2) + credit_sum / 2;
            CreditRequests request2 = new CreditRequests(true, time, requested_credit, false);
            CreditRequestsDao.save(request2);
            people.setCreditRequests(request2);
            peopleService.updatePeople(people);
            return new RedirectView("accepting/?id=" + people.getId());
        }
    }
}
