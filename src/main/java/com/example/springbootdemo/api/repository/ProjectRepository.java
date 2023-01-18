package com.example.springbootdemo.api.repository;

import com.example.springbootdemo.api.entity.Project;
import org.springframework.data.repository.ListCrudRepository;

public interface ProjectRepository extends ListCrudRepository<Project, Integer> {
}
