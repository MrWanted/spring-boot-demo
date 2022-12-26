package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.Person;
import com.example.springbootdemo.api.repository.PersonRepository;
import com.example.springbootdemo.api.service.PersonService;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    @Override
    public Person save(Person person) {
        return repository.save(person);
    }
    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Person> findByID(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
