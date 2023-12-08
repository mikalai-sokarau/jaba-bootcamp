package dev.sokarau.serializer;

/**
 * Bloodhound is a dog, so it extends Dog.
 * String owner is a name of the owner.
 * boolean isQuiet is true if the dog is quiet, false otherwise.
 * int barkingVolume is transient, so it will not be serialized.
 */
public class Bloodhound extends Dog {
  private String owner;
  private boolean isQuiet;
  private transient int barkingVolume;

  public Bloodhound(String name, String owner, int age,
      double weight, int barkingVolume, boolean isQuiet) {
    super(name, age, weight);
    this.owner = owner;
    this.barkingVolume = barkingVolume;
    this.isQuiet = isQuiet;
  }

  @Override
  public String toString() {
    return super.toString()
        + "\nBloodhound fields: owner=" + owner
        + ", barkingVolume=" + barkingVolume
        + ", isQuiet=" + isQuiet;
  }
}
