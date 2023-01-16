package com.example.springbootdemo.api.repository;

import com.example.springbootdemo.api.entity.BankingDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingDetailsRepository extends ListCrudRepository<BankingDetails, Integer> {
}
