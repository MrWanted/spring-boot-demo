package com.example.springbootdemo.api.repository;


import com.example.springbootdemo.api.entity.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {
}
