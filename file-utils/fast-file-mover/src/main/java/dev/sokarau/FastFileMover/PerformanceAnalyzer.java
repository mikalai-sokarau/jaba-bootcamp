package dev.sokarau.FastFileMover;

/**
 * Performance Analyzer class
 * Contains a method to analyze the performance of a given method
 */
public class PerformanceAnalyzer {
  public static final int MAX_ITERATIONS = 100;

  /**
   * Analyzes the performance of a given method
   *
   * @param runnable
   */
  public static void analyze(Runnable runnable) {
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < MAX_ITERATIONS; i++) {
      runnable.run();
    }

    long endTime = System.currentTimeMillis();

    long timeInMilliseconds = endTime - startTime;
    double timeInSeconds = timeInMilliseconds / 1000;

    System.out.println("Total execution time: " + timeInSeconds + "s, " + timeInMilliseconds + "ms");
    System.out.println("Average execution time: " + timeInSeconds / MAX_ITERATIONS + "s, "
        + timeInMilliseconds / MAX_ITERATIONS + "ms");
    System.out.println("Total iterations: " + MAX_ITERATIONS);
  }
}
