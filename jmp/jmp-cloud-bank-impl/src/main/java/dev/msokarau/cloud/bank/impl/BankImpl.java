package dev.msokarau.cloud.bank.impl;

import dev.msokarau.bank.api.Bank;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.BankCardType;
import dev.msokarau.dto.CreditBankCard;
import dev.msokarau.dto.DebitBankCard;
import dev.msokarau.dto.User;

public class BankImpl implements Bank {

  public BankCard createBankCard(User user, BankCardType type) {
    if (type == BankCardType.CREDIT) {
      return new CreditBankCard(user);
    }
    if (type == BankCardType.DEBIT) {
      return new DebitBankCard(user);
    }
    return null;
  }

}
