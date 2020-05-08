package com.springframework.controllers;


import com.springframework.domain.MyUser;
import com.springframework.repositories.MyUserRepository;
import com.springframework.services.MyUserService;
import com.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class ProductController {
    @Autowired
    MyUserRepository userRepository;
    private UserService userService;

    @Autowired
    public void setMyUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String sendForm(MyUser person){
        return "addUser";
    }

    @GetMapping("/login")
    public String sendForm_login(MyUser myUser){
        return "login";
    }

    @PostMapping("/addUser")
    public String process_form(MyUser myUser){
        String name = myUser.getName();
        String username = myUser.getUsername();
        String password = myUser.getPassword();

        // Here check for username availability before making an object and saving in database
        userService.saveMyUser(username,name,password,"USER");
        System.out.println("INSERTED IN DATABASE ++++++++++ " + name + " " + username + " " + password);
        return "index";
    }

    @PostMapping("/login")
    public String process_form_login(MyUser myUser){
        System.out.println("IN POST LOGIN");
        String username = myUser.getUsername();
        String password = myUser.getPassword();
        System.out.println("YOU ENTERED :" + username + " " + password);
        return "login";
    }
    @RequestMapping("/homepage")
    public String home(HttpSession session){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        System.out.println(" =================" + username);
        session.setAttribute("username",username);
        return "homepage";
    }
    @RequestMapping("/")
    public String index(MyUser person) {
        MyUser t = new MyUser("Abhishek Yadav","abhiyad","123","USER");
        userRepository.save(t);
        userService.saveMyUser(t.getName(),t.getUsername(),t.getPassword(),"USER");
        UserDetails user = userService.loadUserByUsername("abhiyad");
        System.out.println(user.getPassword());
        return "index";
    }

}
