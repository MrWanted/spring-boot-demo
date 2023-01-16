package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.BankingDetails;
import com.example.springbootdemo.api.service.BankingDetailsService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/bank")
@Slf4j
@Data
public class BankingController {
    private final BankingDetailsService service;

    @GetMapping("")
    public ResponseEntity<List<BankingDetails>> findAll() {
        log.info("finding  all banking details...");
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankingDetails> findById(@PathVariable Integer id) throws Exception {
        log.info("finding  banking details by id ...", id);
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
