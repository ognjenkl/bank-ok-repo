package com.ognjen.bankok.bankok.controller;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/tax")
public class TaxController {

  private static final BigDecimal TAX_RATE = new BigDecimal("0.17");

  @GetMapping
  public TaxResponse getTaxRate() {
    log.info("Tax rate requested. Returning tax rate: {}", TAX_RATE);
    return new TaxResponse(TAX_RATE);
  }

  public record TaxResponse(BigDecimal taxRate) {

  }
}
