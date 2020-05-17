package com.springframework.services;
import com.springframework.repositories.MyUserRepository;
import com.springframework.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {
    private MyUserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public MyUserService(MyUserRepository repository){
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.repository  = repository;
    }

    public MyUser loadUserByUsername(String username){
        return repository.findMyUserByUsername(username);
    }
    public void saveMyUser(String name,String username,String password,String role){
        MyUser user = new MyUser(name,username,passwordEncoder.encode(password),role);
        //need to add some checks here to check if the user already exists!!
        repository.save(user);
    }
}
