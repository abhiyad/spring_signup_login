package com.springframework.services;
import com.springframework.domain.Person;

import java.util.List;

public interface UserService {
    List<Person> listAll();
    Person getById(Long id);
    void delete(Long id);
}
