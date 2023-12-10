package dev.sokarau.FastFileMover;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * A class that generates a file with a given size.
 * The file is generated in the target folder of the project.
 * Maximum file size is 1GB.
 *
 * 1KB = 1024B
 * 1MB = 1024KB
 * 1GB = 1024MB
 */
public class FileGenarator {
  public static final int METHODS_NUMBER = 1;
  private static final int KB = 1024;
  private static final String FILE_FROM_PATH = "fast-file-mover/target/move-from/";
  private static final String FILE_TO_PATH = "fast-file-mover/target/move-to/";
  private static final String FILE_EXTENSION = ".txt";
  private static final HashMap<String, Integer> SIZES = new HashMap<>() {
    {
      put("1kb", 1);
      put("100kb", 100);
      put("10mb", 10 * KB);
      put("1gb", KB * KB);
    }
  };

  /**
   * Generates a file with a given size.
   * Accepts size in the following format: 1kb, 100kb, 10mb, 1gb
   *
   * @param size
   */
  public static void generateFile(String size) {
    if (!SIZES.containsKey(size)) {
      System.out.println("Please provide valid file size");
      System.exit(0);
    }

    createFolders();

    try (FileOutputStream out = new FileOutputStream(FILE_FROM_PATH + size + FILE_EXTENSION)) {
      byte[] oneKb = new byte[KB];

      for (int i = 0; i < SIZES.get(size); i++) {
        out.write(oneKb);
      }

      System.out.println("File " + size + FILE_EXTENSION + " has been generated.");
    } catch (IOException e) {
      System.out.println("An error has occurred while creating the file.");
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates folders for the files if they don't exist.
   */
  private static void createFolders() {
    try {
      if (!Files.exists(Paths.get(FILE_FROM_PATH))) {
        Files.createDirectories(Paths.get(FILE_FROM_PATH));
      }
      if (!Files.exists(Paths.get(FILE_TO_PATH))) {
        Files.createDirectories(Paths.get(FILE_TO_PATH));
      }
    } catch (IOException e) {
      System.out.println("An error has occurred while creating the folders.");
      System.out.println(e.getMessage());
    }
  }
}
