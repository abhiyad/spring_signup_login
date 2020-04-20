package com.springframework.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springframework.domain.User;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class ProductController {

    @GetMapping("/addUser")
    public String sendForm(User user){
        return "addUser";
    }
    @PostMapping("/addUser")
    public String process_form(User user){
        String fname = user.getFname();
        String lname = user.getLname();
        System.out.println("++++++++++ " + fname + " " + lname);
        return "showUser";
    }
    @RequestMapping("/")
    public String index(User User){
        return "addUser";
    }
}
