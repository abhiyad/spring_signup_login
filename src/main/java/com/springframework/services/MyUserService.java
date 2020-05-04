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
public class MyUserService implements UserService {
    private MyUserRepository repository;
    @Autowired
    public MyUserService(MyUserRepository repository){
        this.repository  = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        MyUser user = repository.findMyUserByUsername(username);
        UserBuilder builder = null;
        if (user!=null){
            builder = User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRole());
        }
        else{
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return builder.build();
    }
    @Override
    public void saveMyUser(String username,String password,String name,String role){
        MyUser user = new MyUser(name,username,password,role);
        //need to add some checks here!!
        repository.save(user);
    }
}
