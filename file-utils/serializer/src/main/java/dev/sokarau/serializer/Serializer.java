package dev.sokarau.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serializer is a class that provides serialization and deserialization.
 * fileName is a name of the file where the object is serialized.
 */
public class Serializer {
  public final static String fileName = "serializer/target/serialized.txt";

  public static void serialize(Object[] objects) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
      for (Object o : objects) {
        System.out.println("\nBefore serialization: \n" + o);
        out.writeObject(objects);
      }

    } catch (Exception e) {
      System.out.println("Error during serialization: " + e.getMessage());
    }
  }

  public static Object[] deserialize() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
      Object[] objects = (Object[]) in.readObject();

      for (Object o : objects) {
        System.out.println("\nAfter deserialization: \n" + o);
      }

      return objects;
    } catch (Exception e) {
      System.out.println("Error during deserialization: " + e.getMessage());
    }
    return null;
  }
}
