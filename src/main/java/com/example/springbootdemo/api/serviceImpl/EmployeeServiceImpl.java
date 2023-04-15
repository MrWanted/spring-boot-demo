package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.exception.ResourceNotFoundException;
import com.example.springbootdemo.api.repository.EmployeeRepository;
import com.example.springbootdemo.api.service.EmployeeService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        return repository.findById(id)
                .map(newEmployee -> {
                    employee.setName(employee.getName());
                    employee.setSurname(employee.getName());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    employee.setId(id);
                    return repository.save(employee);
                });
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findByID(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + id));
    }

    @Override
    public void deleteById(Integer id) {
        Employee person = findByID(id);
        if (person.getId() == id) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Employee not found with id:" + id);
        }
    }
}

