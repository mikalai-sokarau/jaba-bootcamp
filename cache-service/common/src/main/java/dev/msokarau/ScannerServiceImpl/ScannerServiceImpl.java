package dev.msokarau.ScannerServiceImpl;

import java.util.Scanner;
import dev.msokarau.interfaces.ScannerService.ScannerService;
import dev.msokarau.interfaces.CacheService.CacheService;

public class ScannerServiceImpl implements ScannerService {
  CacheService cacheService;
  Scanner scanner = new Scanner(System.in);

  public ScannerServiceImpl(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  public void run() {
    while (true) {
      processCommand(scanner.nextLine());
    }
  }

  private void processCommand(String command) {
    String[] parts = command.split(" ");

    switch (parts[0]) {
      case "exit" -> exit();
      case "put" -> put(parts);
      case "get" -> get(parts);
      case "help" -> help();
      case "stats" -> stats();
      default ->
        System.out.println("> Unknown command: \"" + parts[0] + "\", type 'help' to see available commands\n");
    }
  }

  private void put(String[] parts) {
    if (parts.length > 3) {
      System.out.println("> Invalid command. Expecting put command in format: put <number> or put <key, value>\n");
      return;
    }

    if (parts.length == 3) {
      putSigleValue(parts[1], parts[2]);
    } else {
      putMultipleValues(parts);
    }
  }

  private void putSigleValue(String key, String value) {
    cacheService.put(key, value);
    System.out.println("> \"" + key + ":" + value + "\" added into cache\n");
  }

  private void putMultipleValues(String[] parts) {
    int numberOfEntries = Integer.parseInt(parts[1]);

    for (int i = 1; i <= numberOfEntries; i++) {
      cacheService.put(String.valueOf(i), "Value " + i);
    }

    System.out.println("> " + numberOfEntries + " entries added into cache\n");
  }

  private void get(String[] parts) {
    if (parts.length != 2) {
      System.out.println("> Invalid command. Expecting get command in format: get <key>\n");
      return;
    }

    System.out.println("> Value for key '" + parts[1] + "': " + cacheService.get(parts[1]) + "\n");
  }

  private void stats() {
    System.out.println("> Number of cache evictions: " + cacheService.getEvictionCount());
    System.out.println("> Average time spent for putting new values into cache: " + cacheService.getAveragePutTime()
        + " nanoseconds\n");
  }

  private void help() {
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_RESET = "\u001B[0m";

    System.out.println("""
        > Available commands:

        %1$sput%3$s %2$s<number> or <key, value>%3$s (put <number> entries into cache or put <key, value> into cache)
        %1$sget%3$s %2$s<key>%3$s (get value for <key>)
        %1$sstats%3$s (print cache statistics)
        %1$shelp%3$s (show available commands)
        %1$sexit%3$s (exit the application)
        """.formatted(ANSI_BLUE, ANSI_YELLOW, ANSI_RESET));
  }

  private void exit() {
    scanner.close();
    cacheService.shutdown();
    System.exit(0);
  }
}
