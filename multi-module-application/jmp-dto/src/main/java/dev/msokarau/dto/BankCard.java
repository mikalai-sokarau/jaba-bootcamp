package dev.msokarau.dto;

import org.apache.commons.lang3.RandomStringUtils;

public class BankCard {
  public String number;
  public User user;

  BankCard(User user) {
    this.user = user;
    this.number = RandomStringUtils.randomNumeric(16);
  }
}
