package dev.msokarau.dto;

import java.time.LocalDate;
import java.util.Random;

public class User {
  public String name;
  public String surname;
  public LocalDate birthday;

  public User(String name) {
    this.name = name;
    this.birthday = generageBirthday();
  }

  private LocalDate generageBirthday() {
    int MAX_AGE = 100;

    return LocalDate.now().minusYears(new Random().nextInt(MAX_AGE));
  }

  public String toString() {
    return name + " " + birthday;
  }
}
