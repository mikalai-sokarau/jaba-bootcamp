package dev.msokarau.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dev.msokarau.service.api.Service;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.Subscription;
import dev.msokarau.dto.User;
import com.google.auto.service.AutoService;

@AutoService(Service.class)
public class ServiceImpl implements Service {
  final private List<Subscription> subscriptions = new ArrayList<>();
  final private List<User> users = new ArrayList<>();

  public void subscribe(BankCard card) {
    users.add(card.user);
    subscriptions.add(new Subscription(card.number));
  }

  public Subscription getSubscriptionByBankCardNumber(String cardNumber) {
    return subscriptions.stream()
        .filter(subscription -> subscription.bankcard.equals(cardNumber))
        .findFirst()
        .orElseThrow(() -> new NoSubscriptionFoundException(cardNumber));
  }

  public List<User> getAllUsers() {
    return this.users.stream()
        .collect(Collectors.toUnmodifiableList());
  }

  public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
    return subscriptions.stream()
        .filter(condition)
        .collect(Collectors.toUnmodifiableList());
  };
}
