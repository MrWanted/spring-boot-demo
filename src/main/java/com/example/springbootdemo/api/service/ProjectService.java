package com.example.springbootdemo.api.service;


import com.example.springbootdemo.api.entity.Project;

import java.util.List;

public interface ProjectService {
    Project save(Project project);
    Project update(Project project, Integer id);
    List<Project> findAll();
    Project findByID(Integer id) throws Exception;
    void deleteById(Integer id);
}
