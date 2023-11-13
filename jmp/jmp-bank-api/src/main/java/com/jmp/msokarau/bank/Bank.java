package com.jmp.msokarau.bank;

import com.jmp.msokarau.classes.User;
import com.jmp.msokarau.classes.BankCard;
import com.jmp.msokarau.constants.BankCardType;

public interface Bank {
  public BankCard createBankCard(User user, BankCardType type);
}
