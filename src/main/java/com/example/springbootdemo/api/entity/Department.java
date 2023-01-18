package com.example.springbootdemo.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    private String code;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<Employee> employees;
}
