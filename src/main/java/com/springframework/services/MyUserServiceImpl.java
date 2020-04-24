package com.springframework.services;
import com.springframework.domain.MyUser;
import com.springframework.repositories.MyUserRepository;
import com.springframework.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService{
    private MyUserRepository userRepository;
    @Autowired
    public MyUserServiceImpl(MyUserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<MyUser> listAll(){
        List <MyUser> userArray = new ArrayList<>();
        userRepository.findAll().forEach(userArray::add);
        return userArray;
    }
}
