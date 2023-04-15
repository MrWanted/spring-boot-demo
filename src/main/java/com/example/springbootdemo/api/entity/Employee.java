package com.example.springbootdemo.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Schema(example = "2")
    private Integer id;

    @Schema(example = "Lerato")
    @NotNull(message = "name should be provided")
    private String name;
    @Schema(example = "Lepota")
    @NotNull(message = "surname should be provided")
    private String surname;

    @Email
    @Schema(example = "lerato@lepota.co.za")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bank_id")
    private BankingDetails bankingDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_department_id")
    private Department department;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;
}
