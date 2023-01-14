package com.example.springbootdemo.api.service;

import com.example.springbootdemo.api.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person product);
    Person update(Person product, Integer id);
    List<Person> findAll();
    Person findByID(Integer id) throws Exception;
    void deleteById(Integer id);
}
