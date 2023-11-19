package dev.msokarau.application;

import dev.msokarau.bank.api.Bank;
import dev.msokarau.cloud.bank.impl.BankImpl;
import dev.msokarau.cloud.service.impl.ServiceImpl;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.BankCardType;
import dev.msokarau.dto.User;
import dev.msokarau.service.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Bank bank = new BankImpl();
        Service service = new ServiceImpl();

        List<BankCard> cards = subscribeUsers(generateUsers(), bank, service);

        printSubscriptions(cards, service);
        printUsers(service.getAllUsers());
        printAverageAge(service);
    }

    private static List<User> generateUsers() {
        List<User> users = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            User user = new User("User" + i);
            users.add(user);
        }

        return users;
    }

    private static List<BankCard> subscribeUsers(List<User> users, Bank bank, Service service) {
        Random random = new Random();
        List<BankCard> cards = new ArrayList<>(users.size());

        for (User user : users) {
            BankCardType cardType = random.nextBoolean() ? BankCardType.CREDIT : BankCardType.DEBIT;
            BankCard card = bank.createBankCard(user, cardType);

            cards.add(card);
            service.subscribe(card);
        }

        return cards;
    }

    private static void printSubscriptions(List<BankCard> cards, Service service) {
        System.out.println("\nSubscriptions: ");

        cards.forEach((card) -> System.out.println(service.getSubscriptionByBankCardNumber(card.number)));
    }

    private static void printUsers(List<User> users) {
        System.out.println("\nUsers: ");

        users.forEach((user) -> System.out.println(user + " is payable: " + Service.isPayableUser(user)));
    }

    private static void printAverageAge(Service service) {
        System.out.println("\nAverage age: " + service.getAverageUsersAge());
    }
}
