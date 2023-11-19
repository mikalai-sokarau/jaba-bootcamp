package dev.msokarau.cloud.service.impl;

public class NoSubscriptionFoundException extends RuntimeException {
  public NoSubscriptionFoundException(String cardNumber) {
    super("No subscription found for the card number: " + cardNumber);
  }
}
