package dev.msokarau.service.api;

import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.User;
import dev.msokarau.dto.Subscription;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface Service {

  public void subscribe(BankCard card);

  public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

  public List<User> getAllUsers();

  public static boolean isPayableUser(User user) {
    final int PAYABLE_AGE = 18;

    return ChronoUnit.YEARS.between(user.birthday, LocalDate.now()) >= PAYABLE_AGE;
  }

  default double getAverageUsersAge() {
    List<User> users = getAllUsers();

    long totalAge = users.stream()
        .mapToLong(user -> Period.between(user.birthday, LocalDate.now()).getYears())
        .sum();

    return (double) totalAge / users.size();
  }

}
