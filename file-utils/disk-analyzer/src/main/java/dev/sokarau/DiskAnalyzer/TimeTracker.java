package dev.sokarau.DiskAnalyzer;

/**
 * Time Tracker class
 * Contains a method to track the execution time of a given method
 */
public class TimeTracker {
  public static void track(Runnable runnable) {
    long startTime = System.currentTimeMillis();

    runnable.run();

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    double executionTimeInSeconds = executionTime / 1000;
    System.out.println("Execution time: " + executionTimeInSeconds + " seconds");
  }
}
