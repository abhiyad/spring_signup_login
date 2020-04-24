package com.springframework.controllers;


import com.springframework.domain.MyUser;
import com.springframework.repositories.MyUserRepository;
import com.springframework.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class ProductController {
    private MyUserService myuserService;
    @Autowired
    MyUserRepository userRepository;
    @Autowired
    public void setUserService(MyUserService myuserService){
        this.myuserService = myuserService;
    }

    @GetMapping("/addUser")
    public String sendForm(MyUser person){
        return "addUser";
    }

    @GetMapping("/login")
    public String sendForm_login(MyUser person){
        return "login";
    }

    @PostMapping("/addUser")
    public String process_form(MyUser myUser, Model model){
        String name = myUser.getName();
        String username = myUser.getUsername();
        String password = myUser.getPassword();

        // Here check for username availability before making an object and saving in database
        MyUser u = new MyUser(name,username,password);
        userRepository.save(u);
        System.out.println("INSERTED IN DATABASE ++++++++++ " + name + " " + username + " " + password);
        model.addAttribute("myUser",userRepository.findAll());
        List<MyUser> l = userRepository.findAll();
        return "showAll";
    }

    @PostMapping("/login")
    public String process_form_login(MyUser myUser, Model model){
        String username = myUser.getUsername();
        String password = myUser.getPassword();
        System.out.println("YOU ENTERED :" + username + " " + password);
        return "index";
    }

    @GetMapping("showAll")
    public String showAll(Model model){
        model.addAttribute("myUser",userRepository.findAll());
        return "showAll";
    }

    @RequestMapping("/")
    public String index(MyUser person) {
        return "index";
    }

//    @RequestMapping("/product/show/{id}")
//    public String getProduct(@PathVariable String id, Model model){
//        model.addAttribute("person", userService.getById(Long.valueOf(id)));
//        return "showUser";
//    }
//    @RequestMapping("/product/delete/{id}")
//    public String deleteProduct(@PathVariable String id, Model model){
//        userService.delete(Long.valueOf(id));
//        model.addAttribute("person",repository.findAll());
//        return "showAll";
//    }
}
