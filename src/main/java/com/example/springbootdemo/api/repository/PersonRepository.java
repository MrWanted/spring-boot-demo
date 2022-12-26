package com.example.springbootdemo.api.repository;


import com.example.springbootdemo.api.entity.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Integer> {
}
