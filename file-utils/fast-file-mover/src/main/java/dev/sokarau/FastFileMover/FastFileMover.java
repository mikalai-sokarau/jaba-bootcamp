package dev.sokarau.FastFileMover;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * A class that moves a file from one location to another.
 */
public class FastFileMover {
  public static final int METHODS_NUMBER = 4;

  /**
   * Moves a file using file streams.
   *
   * @param inputFile
   * @param outputFile
   */
  public static void moveFileUsingFileStreams(String inputFile, String outputFile) {
    try (InputStream in = new FileInputStream(inputFile);
        OutputStream out = new FileOutputStream(outputFile)) {
      int bytesRead;

      while ((bytesRead = in.read()) != -1) {
        out.write(bytesRead);
      }
    } catch (IOException e) {
      System.out.println("An error has occurred while processing the files.");
      System.out.println(e.getMessage());
    }
  }

  /**
   * Moves a file using file streams with a given buffer size.
   *
   * @param inputFile
   * @param outputFile
   * @param bufferSize
   */
  public static void moveFileUsingFileStreams(String inputFile, String outputFile, int bufferSize) {
    try (InputStream in = new FileInputStream(inputFile);
        OutputStream out = new FileOutputStream(outputFile)) {
      int bytesRead;
      byte[] buffer = new byte[bufferSize];

      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
      }
    } catch (IOException e) {
      System.out.println("An error has occurred while processing the files.");
      System.out.println(e.getMessage());
    }
  }

  /**
   * Moves a file using file channel.
   *
   * @param inputFile
   * @param outputFile
   */
  public static void moveFileUsingFileChannel(String inputFile, String outputFile) {
    try (FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel()) {
      inChannel.transferTo(0, inChannel.size(), outChannel);
    } catch (IOException e) {
      System.out.println("An error has occurred while processing the files.");
      System.out.println(e.getMessage());
    }
  }

  /**
   * Moves a file using NIO.
   *
   * @param inputFile
   * @param outputFile
   */
  public static void moveFileUsingNio(String inputFile, String outputFile) {
    Path inputPath = Path.of(inputFile);
    Path outputPath = Path.of(outputFile);

    try {
      Files.copy(inputPath, outputPath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      System.out.println("An error has occurred while moving the file.");
      System.out.println(e.getMessage());
    }
  }
}