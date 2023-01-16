package com.example.springbootdemo.api.service;

import com.example.springbootdemo.api.entity.BankingDetails;

import java.util.List;

public interface BankingDetailsService {
    List<BankingDetails> findAll();
    BankingDetails findById(Integer id);
}
