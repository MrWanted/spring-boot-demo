package com.example.springbootdemo.api.service;


import com.example.springbootdemo.api.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    Department update(Department department, Integer id);
    List<Department> findAll();
    Department findByID(Integer id) throws Exception;
    void deleteById(Integer id);
}
