package com.example.springbootdemo.api.repository;

import com.example.springbootdemo.api.entity.Department;
import org.springframework.data.repository.ListCrudRepository;

public interface DepartmentRepository extends ListCrudRepository<Department,Integer> {
}
