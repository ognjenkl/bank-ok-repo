package com.ognjen.bankok.bankok.controller;

import lombok.Builder;

@Builder
public record Expense(Long id, String envelopeName, String title, Double price) {

}
