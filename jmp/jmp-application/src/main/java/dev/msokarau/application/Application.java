package dev.msokarau.application;

import dev.msokarau.bank.api.Bank;
import dev.msokarau.cloud.bank.impl.BankImpl;
import dev.msokarau.cloud.service.impl.ServiceImpl;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.BankCardType;
import dev.msokarau.dto.Subscription;
import dev.msokarau.dto.User;
import dev.msokarau.service.api.Service;

import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        Bank bank = new BankImpl();
        Service service = new ServiceImpl();

        BankCard creditCard = bank.createBankCard(new User("User1"), BankCardType.CREDIT);
        BankCard debitCard = bank.createBankCard(new User("User2"), BankCardType.DEBIT);

        service.subscribe(creditCard);
        service.subscribe(debitCard);

        Optional<Subscription> subscription1 = service.getSubscriptionByBankCardNumber(creditCard.number);
        Optional<Subscription> subscription2 = service.getSubscriptionByBankCardNumber(debitCard.number);
        Optional<Subscription> subscription3 = service.getSubscriptionByBankCardNumber("1234567890");

        System.out.println("Subscription1: " + subscription1);
        System.out.println("Subscription2: " + subscription2);
        System.out.println("Subscription3: " + subscription3);

        List<User> users = service.getAllUsers();
        System.out.println("Users: " + users);
    }
}
