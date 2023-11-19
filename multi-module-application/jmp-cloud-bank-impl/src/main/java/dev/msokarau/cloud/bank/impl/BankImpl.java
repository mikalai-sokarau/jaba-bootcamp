package dev.msokarau.cloud.bank.impl;

import java.util.Map;
import java.util.function.Function;

import dev.msokarau.bank.api.Bank;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.BankCardType;
import dev.msokarau.dto.CreditBankCard;
import dev.msokarau.dto.DebitBankCard;
import dev.msokarau.dto.User;

public class BankImpl implements Bank {

  private final Map<BankCardType, Function<User, BankCard>> cardConstructor = Map.of(
      BankCardType.CREDIT, CreditBankCard::new,
      BankCardType.DEBIT, DebitBankCard::new);

  public BankCard createBankCard(User user, BankCardType type) {
    return cardConstructor.get(type).apply(user);
  }

}
