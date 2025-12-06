package com.ognjen.bankok.bankok.controller;

import java.math.BigDecimal;
import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/subscription-discount")
public class SubscriptionDiscountController {

  @GetMapping
  public DiscountResponse getDiscount() {
    LocalTime currentTime = LocalTime.now();
    BigDecimal discount = currentTime.isBefore(LocalTime.of(16, 0))
        ? new BigDecimal("0.20")
        : new BigDecimal("0.10");
    log.info("Subscription discount requested at {}. Returning discount: {}", currentTime, discount);
    return new DiscountResponse(discount);
  }

  public record DiscountResponse(BigDecimal discount) {

  }
}
