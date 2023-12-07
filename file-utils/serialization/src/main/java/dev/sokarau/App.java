package dev.sokarau;

import java.lang.System;
import dev.sokarau.serializer.Dog;
import dev.sokarau.serializer.Bloodhound;
import dev.sokarau.serializer.GreatDane;
import dev.sokarau.serializer.Serializer;

/**
 * App is a main class of the application.
 * It provides two operations: serialization and deserialization.
 * Serialization is performed by the serialize() method.
 * Deserialization is performed by the deserialize() method.
 * The name of the operation is passed as a command line argument.
 */
public class App {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide an operation type");
            System.exit(1);
        }

        switch (args[0]) {
            case "serialize":
                serialize();
                break;
            case "deserialize":
                deserialize();
                break;
            default:
                System.out.println("Please provide a type of the operation: \n> serialize\n> deserialize");
        }
    }

    private static void serialize() {
        Dog[] dogs = {
                new GreatDane("Scooby-Doo", "Shaggy Rogers", 10, 21, 2, true),
                new Bloodhound("Pluto", "Mickey Mouse", 8, 13, 10, false),
        };

        Serializer.serialize(dogs);
    }

    private static void deserialize() {
        Serializer.deserialize();
    }
}
