package dev.sokarau.serializer;

/**
 * GreatDane is a dog, so it extends Dog.
 * String owner is a name of the owner.
 * boolean isQuiet is true if the dog is quiet, false otherwise.
 * int barkingVolume is transient, so it will not be serialized.
 */
public class GreatDane extends Dog {
  private String owner;
  private boolean isQuiet;
  private transient int barkingVolume;

  public GreatDane(String name, String owner, int age,
      double weight, int barkingVolume, boolean isQuiet) {
    super(name, age, weight);
    this.owner = owner;
    this.barkingVolume = barkingVolume;
    this.isQuiet = isQuiet;
  }

  @Override
  public String toString() {
    return super.toString()
        + "\nGreatDane fields: owner=" + owner
        + ", barkingVolume=" + barkingVolume
        + ", isQuiet=" + isQuiet;
  }
}
