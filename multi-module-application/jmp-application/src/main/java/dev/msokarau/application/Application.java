package dev.msokarau.application;

import dev.msokarau.bank.api.Bank;
import dev.msokarau.cloud.bank.impl.BankImpl;
import dev.msokarau.dto.BankCard;
import dev.msokarau.dto.BankCardType;
import dev.msokarau.dto.User;
import dev.msokarau.service.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;

public class Application {
    public static void main(String[] args) {
        Bank bank = new BankImpl();
        Service service = loadService();

        List<BankCard> cards = subscribeUsers(generateUsers(), bank, service);

        printSubscriptions(cards, service);
        printUsers(service.getAllUsers());
        printAverageAge(service);
        printEvenSubscriptions(service);
        printSubscriptionException(service);
    }

    private static Service loadService() {
        ServiceLoader<Service> services = ServiceLoader.load(Service.class);
        Service service = null;

        for (Service s : services) {
            if (s instanceof Service) {
                service = s;
            }
        }

        if (service == null) {
            throw new RuntimeException("Service not found");
        }

        return service;
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

        users.forEach((user) -> System.out.println(user + ", is payable: " + Service.isPayableUser(user)));
    }

    private static void printAverageAge(Service service) {
        System.out.println("\nAverage age: " + service.getAverageUsersAge());
    }

    private static void printEvenSubscriptions(Service service) {
        System.out.println("\nSubscriptions by condition (only even): ");

        service.getAllSubscriptionsByCondition(
                (subscription) -> subscription.bankcard.charAt(subscription.bankcard.length() - 1) % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printSubscriptionException(Service service) {
        try {
            service.getSubscriptionByBankCardNumber("___");
        } catch (Exception e) {
            System.out.println("\nException: \n" + e.getMessage());
        }
    }
}
