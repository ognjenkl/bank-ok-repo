package com.ognjen.bankok.bankok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

  @GetMapping
  public String getAllExpenses() {
    return """
        {
        "id": 2,
        "userId": 142,
        "totalProducts": 5,
        "totalQuantity": 20,
        "total": 4794.8,
        "products": [
        {
        "id": 144,
        "title": "Cricket Helmet",
        "price": 44.99,
        "quantity": 4,
        "total": 179.96,
        "discountedPrice": 0
        },
        {
        "id": 124,
        "title": "iPhone X",
        "price": 899.99,
        "quantity": 4,
        "total": 3599.96,
        "discountedPrice": 0
        },
        {
        "id": 148,
        "title": "Golf Ball",
        "price": 9.99,
        "quantity": 4,
        "total": 39.96,
        "discountedPrice": 0
        },
        {
        "id": 122,
        "title": "iPhone 6",
        "price": 299.99,
        "quantity": 3,
        "total": 899.97,
        "discountedPrice": 0
        },
        {
        "id": 110,
        "title": "Selfie Lamp with iPhone",
        "price": 14.99,
        "quantity": 5,
        "total": 74.95,
        "discountedPrice": 0
        }
        ],
        "discountedTotal": 4288.95
        }""";
  }
}
