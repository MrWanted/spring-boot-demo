package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.Department;
import com.example.springbootdemo.api.exception.ResourceNotFoundException;
import com.example.springbootdemo.api.repository.DepartmentRepository;
import com.example.springbootdemo.api.service.DepartmentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@Data
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public Department update(Department department, Integer id) {
        return repository.findById(id)
                .map(newDepartment -> {
                    department.setName(department.getName());
                    department.setCode(department.getCode());
                    return repository.save(department);
                })
                .orElseGet(() -> {
                    department.setId(id);
                    return repository.save(department);
                });
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Department findByID(Integer id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Department not found with id:" + id));
    }

    @Override
    public void deleteById(Integer id) {
        Department department = findByID(id);
        if (department.getId() == id) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Department not found with id:" + id);
        }
    }
}
