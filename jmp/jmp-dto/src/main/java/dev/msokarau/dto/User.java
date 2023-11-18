package dev.msokarau.dto;

import java.time.LocalDate;

public class User {
  String name;
  String surname;
  LocalDate birthday;

  public User(String name) {
    this.name = name;
  }
}
