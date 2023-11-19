package dev.msokarau.cloud.service.impl;

import dev.msokarau.service.api.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.Subscription;
import dev.msokarau.dto.User;

public class ServiceImpl implements Service {
  private List<Subscription> subscriptions = new ArrayList<>();
  private List<User> users = new ArrayList<>();

  public void subscribe(BankCard card) {
    users.add(card.user);
    subscriptions.add(new Subscription(card.number));
  }

  public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
    return subscriptions.stream()
        .filter(subscription -> subscription != null && subscription.bankcard.equals(cardNumber))
        .findFirst();
  }

  public List<User> getAllUsers() {
    return this.users;
  }
}
