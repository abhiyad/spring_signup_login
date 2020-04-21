package com.springframework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springframework.domain.Person;
import com.springframework.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class ProductController {
    @Autowired
    UserRepository repository;

    @GetMapping("/addUser")
    public String sendForm(Person person){
        return "addUser";
    }
    @PostMapping("/addUser")
    public String process_form(Person person){
        String fname = person.getFname();
        String lname = person.getLname();
        Person u = new Person(fname,lname);
        repository.save(u);
        System.out.println("++++++++++ " + fname + " " + lname);
        System.out.println("CURRENT DATABASE ::: ");
        List<Person> personList = repository.findAll();
        for (Person p : personList) {
            System.out.println("PERSON : " + p.getFname() + " " + p.getLname());
        }
        return "showUser";
    }
    @GetMapping("showAll")
    public String showAll(Model model){
        model.addAttribute("person",repository.findAll());
        return "showAll";
    }
    @RequestMapping("/")
    public String index(Person person) {
        return "index";
    }
}
