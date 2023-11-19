package dev.msokarau.dto;

import java.time.LocalDate;

public class Subscription {
  public String bankcard;
  public LocalDate startDate;

  public Subscription(String bankcard) {
    this.bankcard = bankcard;
    this.startDate = LocalDate.now();
  }

  public String toString() {
    return bankcard;
  }
}
