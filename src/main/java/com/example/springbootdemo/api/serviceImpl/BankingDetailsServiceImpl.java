package com.example.springbootdemo.api.serviceImpl;

import com.example.springbootdemo.api.entity.BankingDetails;
import com.example.springbootdemo.api.repository.BankingDetailsRepository;
import com.example.springbootdemo.api.service.BankingDetailsService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@Data
public class BankingDetailsServiceImpl implements BankingDetailsService {
    private final BankingDetailsRepository repository;

    @Override
    public List<BankingDetails> findAll() {
        return repository.findAll();
    }
    @Override
    public BankingDetails findById(Integer id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Bank details Not Found"));
    }
}
