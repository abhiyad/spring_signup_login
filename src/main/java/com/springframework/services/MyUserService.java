package com.springframework.services;

import com.springframework.domain.MyUser;

import java.util.List;

public interface MyUserService {
    List<MyUser> listAll();
}
