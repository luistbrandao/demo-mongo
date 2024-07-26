package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.infra.Expense;
import com.example.demo.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
	}
	
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(
						String.format("cannot find id %s", expense.getId())));
		savedExpense.setExpanseName(expense.getExpanseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		expenseRepository.save(savedExpense);
	}
	
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
	
	public Optional<Expense> getExpenseByName(String nome) {
		return expenseRepository.findByNome(nome);
	}
	
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
