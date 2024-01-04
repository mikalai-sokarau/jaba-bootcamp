package dev.sokarau.MailTemplateGenerator;

import java.util.Scanner;

public class MailTemplateGenerator {
  private Scanner scanner;

  public MailTemplateGenerator(String mode) {
    if (mode.equals("console")) {
      scanner = new Scanner(System.in);
    }
  }
}
