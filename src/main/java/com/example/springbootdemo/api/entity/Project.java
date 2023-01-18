package com.example.springbootdemo.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    private String code;
    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<Employee> employees;

}

