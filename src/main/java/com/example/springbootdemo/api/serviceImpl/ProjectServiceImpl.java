package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.Project;
import com.example.springbootdemo.api.exception.ResourceNotFoundException;
import com.example.springbootdemo.api.repository.ProjectRepository;
import com.example.springbootdemo.api.service.ProjectService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Data
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    @Override
    public Project save(Project project) {
        return repository.save(project);
    }
    @Override
    public Project update(Project project, Integer id) {
        return repository.findById(id)
                .map(newEmployee -> {
                    project.setName(project.getName());
                    project.setCode(project.getCode());
                    return repository.save(project);
                })
                .orElseGet(() -> {
                    project.setId(id);
                    return repository.save(project);
                });
    }
    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }
    @Override
    public Project findByID(Integer id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Project not found!!!"));
    }

    @Override
    public void deleteById(Integer id) {
        Project project = findByID(id);
        if (project.getId() == id) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("resource not found with id: " + id);
        }
    }
}
