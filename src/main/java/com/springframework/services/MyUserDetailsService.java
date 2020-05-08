package com.springframework.services;

import com.springframework.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserService myUserService;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        MyUser user = myUserService.loadUserByUsername(userName);
        List<GrantedAuthority> authorities = getUserAuthority();
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority() {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("USER"));
        return new ArrayList<>(roles);
    }
    private UserDetails buildUserForAuthentication(MyUser user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, authorities);
    }
}
