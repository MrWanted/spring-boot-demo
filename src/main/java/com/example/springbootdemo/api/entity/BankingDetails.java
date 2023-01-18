package com.example.springbootdemo.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class BankingDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bank_id", nullable = false)
    private Integer id;
    private String accountNumber;

    private String bankName;

    private String branchCode;

    private String accountType;

    @OneToOne(mappedBy = "bankingDetails")
    @JsonIgnore
    private Employee employee;
}
