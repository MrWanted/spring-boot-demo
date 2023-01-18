package com.example.springbootdemo.api.service;

import com.example.springbootdemo.api.entity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee save(Employee product);
    Employee update(Employee product, Integer id);
    List<Employee> findAll();
    Employee findByID(Integer id) throws Exception;
    void deleteById(Integer id);
}
