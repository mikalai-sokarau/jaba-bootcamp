package dev.msokarau.application;

import dev.msokarau.dto.User;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<User> users = createUsers();
        System.out.println("Users: " + users);
    }

    private static ArrayList<User> createUsers() {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            users.add(new User("User" + (i + 1)));
        }

        return users;
    }
}
