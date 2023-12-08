package dev.sokarau.serializer;

/**
 * Dog is an animal, so it extends Animal.
 * double weight is transient, so it will not be serialized.
 */
public class Dog extends Animal {
  private transient double weight;

  public Dog(String name, int age, double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return super.toString() + "\nDog fields: weight=" + weight;
  }
}
