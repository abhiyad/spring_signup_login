package com.springframework.services;

import com.springframework.domain.MyUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    public void saveMyUser(String username,String password,String name,String role);
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
