package com.springframework.services;
import com.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springframework.domain.Person;
import com.springframework.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository repository;
    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Person> listAll(){
        List <Person> personArray = new ArrayList<>();
        repository.findAll().forEach(personArray::add);
        return personArray;
    }
    @Override
    public Person getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

}
