package com.springframework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springframework.domain.Person;
import com.springframework.repositories.UserRepository;
import com.springframework.services.UserService;
import com.springframework.services.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class ProductController {
    private UserService userService;
    @Autowired
    UserRepository repository;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

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
        System.out.println("INSERTED IN DATABASE ++++++++++ " + fname + " " + lname);
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

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("person", userService.getById(Long.valueOf(id)));
        return "showUser";
    }
}
