package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.infra.Expense;
import com.example.demo.service.ExpenseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> addExpense(@RequestBody Expense expense) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(expense));
		expenseService.addExpense(expense);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity updateExpense(@RequestBody Expense expense) {
		expenseService.updateExpense(expense);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return ResponseEntity.ok(expenseService.getAllExpenses());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<Optional<Expense>> getExpenseByName(@PathVariable String nome) {
		return ResponseEntity.ok(expenseService.getExpenseByName(nome));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteExpense(String id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
