package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.infra.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
	
	@Query("{'nome': ?0}")
	Optional<Expense> findByNome(String nome);

}
