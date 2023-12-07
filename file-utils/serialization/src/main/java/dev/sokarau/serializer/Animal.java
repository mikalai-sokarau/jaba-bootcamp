package dev.sokarau.serializer;

import java.io.Serializable;

/**
 * Base class for all animals.
 * int age is transient, so it will not be serialized.
 */
public abstract class Animal implements Serializable {
  public transient int age;
  public String name;

  @Override
  public String toString() {
    return "Animal fields: age=" + age + ", name=" + name;
  }
}