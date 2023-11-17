package dev.msokarau.service.api;

import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.User;
import dev.msokarau.dto.Subscription;
import java.util.List;
import java.util.Optional;

public interface Service {

  public void subscribe(BankCard card);

  public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

  public List<User> getAllUsers();

}
