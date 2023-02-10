package com.example.springbootdemo.api.dto;

import com.example.springbootdemo.api.entity.BankingDetails;
import com.example.springbootdemo.api.entity.Project;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@Builder
@ToString
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;

    private BankingDetails bankingDetails;

    private Set<Project> projects;
}
