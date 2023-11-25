package dev.msokarau.services.Scanner;

import java.util.Scanner;
import dev.msokarau.services.Cache.CacheService;

public class ScannerService {
  CacheService cacheService;
  Scanner scanner = new Scanner(System.in);

  public ScannerService(CacheService cacheService) {
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
      case "time" -> averageTime();
      case "stats" -> stats();
      default -> System.out.println("\nUnknown command, type 'help' to see available commands");
    }
  }

  private void put(String[] parts) {
    if (parts.length != 2) {
      System.out.println("\nInvalid command. Expecting put command in format: put <number>");
      return;
    }

    int numberOfEntries = Integer.parseInt(parts[1]);

    for (int i = 1; i <= numberOfEntries; i++) {
      cacheService.put(String.valueOf(i), "Value " + i);
    }

    System.out.println(numberOfEntries + " entries added into cache");
  }

  private void get(String[] parts) {
    if (parts.length != 2) {
      System.out.println("\nInvalid command. Expecting get command in format: get <key>");
      return;
    }

    System.out.println("Value for key '" + parts[1] + "': " + cacheService.get(parts[1]));
  }

  private void averageTime() {
    System.out.println("\nAverage time spent for putting new values into cache: " + cacheService.getAveragePutTime()
        + " nanoseconds");
  }

  private void stats() {
    System.out.println("\nNumber of cache evictions: " + cacheService.getEvictionCount());
  }

  private void help() {
    System.out.println("""
        ========================================
        Available commands:

        \u001B[34mput\u001B[0m \u001B[33m<number>\u001B[0m (put <number> entries into cache)
        \u001B[34mget\u001B[0m \u001B[33m<key>\u001B[0m (get value for <key>)
        \u001B[34mstats\u001B[0m (print cache statistics)
        \u001B[34mtime\u001B[0m (print average time spent for putting new values into cache)
        \u001B[34mexit\u001B[0m (exit the application)
        ========================================
        """);
  }

  private void exit() {
    scanner.close();
    cacheService.shutdown();
    System.exit(0);
  }
}
