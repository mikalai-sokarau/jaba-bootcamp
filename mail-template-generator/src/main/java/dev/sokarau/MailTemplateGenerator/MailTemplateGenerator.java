package dev.sokarau.MailTemplateGenerator;

import java.util.Scanner;

public class MailTemplateGenerator {
  private Scanner scanner;

  public MailTemplateGenerator(String mode) {
    if (mode.equals("console")) {
      scanner = new Scanner(System.in);
    }
  }

  public MailTemplateGenerator(String[] args) {
    if (args.length == 3 && args[0].equals("file")) {
      String templateFileName = args[1];
      String outputFileName = args[2];
    }
  }
}
