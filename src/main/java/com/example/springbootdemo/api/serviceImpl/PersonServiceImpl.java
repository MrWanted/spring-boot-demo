package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.Person;
import com.example.springbootdemo.api.exception.PersonNotFoundExeption;
import com.example.springbootdemo.api.repository.PersonRepository;
import com.example.springbootdemo.api.service.PersonService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Person person, Integer id) {
        return repository.findById(id)
                .map(newPerson -> {
                    person.setName(person.getName());
                    person.setSurname(person.getName());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    person.setId(id);
                    return repository.save(person);
                });
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findByID(Integer id) {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundExeption(id));
    }

    @Override
    public void deleteById(Integer id) {
        Person person = findByID(id);
        if (person.getId() == id) {
            repository.deleteById(id);
        } else {
            throw new PersonNotFoundExeption(id);
        }
    }
}

