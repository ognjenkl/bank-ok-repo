package com.ognjen.bankok.bankok.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

  private final Map<Long, Expense> expenses = new HashMap<>();

  public ExpenseController() {

    List<Expense> sampleExpenses = List.of(
        Expense.builder().id(144L).envelopeName("Sports").title("Cricket Helmet").price(44.99).build(),
        Expense.builder().id(124L).envelopeName("Electronics").title("iPhone X").price(899.99).build(),
        Expense.builder().id(148L).envelopeName("Sports").title("Golf Ball").price(9.99).build(),
        Expense.builder().id(122L).envelopeName("Electronics").title("iPhone 6").price(299.99).build(),
        Expense.builder().id(110L).envelopeName("Accessories").title("Selfie Lamp with iPhone").price(14.99).build()
    );

    sampleExpenses.forEach(expense -> expenses.put(expense.id(), expense));
  }

  @GetMapping
  public List<Expense> getAllExpenses() {
    return new ArrayList<>(expenses.values());
  }

  @PostMapping("/create-expense")
  @ResponseStatus(HttpStatus.CREATED)
  public Expense createExpense(@RequestBody Expense expense) {

    long newId = expenses.keySet().stream()
        .mapToLong(Long::longValue)
        .max()
        .orElse(0L) + 1;

    Expense newExpense = Expense.builder()
        .id(newId)
        .envelopeName(expense.envelopeName())
        .title(expense.title())
        .price(expense.price())
        .build();
    expenses.put(newId, newExpense);

    return newExpense;
  }
}
