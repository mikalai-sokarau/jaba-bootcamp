package dev.sokarau.DiskAnalyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

/**
 * Disk Analyzer class
 * Contains methods to analyze a given directory and print the results to a file
 */
public class DiskAnalyzer {
    public static final int FUNCTION_NUMBERS = 4;
    private static final String OUTPUT_FILENAME = "disk-analyzer/target/diskAnalyzerOutput.txt";

    /**
     * Searches for the file name with the maximum number of letters in the
     * name, displays the path to it.
     *
     * @param path
     * @param letter
     */
    public static void getMaxFileByLetter(Path path, char letter) {
        Path maxSFilePath = null;
        int maxSCount = 0;

        try (Stream<Path> paths = Files.walk(path)) {
            List<Path> filePaths = new ArrayList<>(paths.collect(Collectors.toList()));

            for (Path filePath : filePaths) {
                if (Files.isRegularFile(filePath)) {
                    String fileName = filePath.getFileName().toString();
                    int sCount = (int) fileName.chars().filter(ch -> ch == letter).count();

                    if (sCount > maxSCount) {
                        maxSCount = sCount;
                        maxSFilePath = filePath;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error during scanning files:\n" + e.getMessage());
        }

        if (maxSFilePath != null) {
            System.out.println("File with the maximum number of \"" + letter + "\" letters: " + maxSFilePath);
        } else {
            System.out.println("No file with \"" + letter + "\" letters found.");
        }

        try (FileWriter fw = new FileWriter(OUTPUT_FILENAME)) {
            fw.write("File with the maximum number of \"" + letter + "\" letters: " + maxSFilePath);
        } catch (IOException e) {
            System.out.println("Error during writing to the output file:\n" + e.getMessage());
        }
    }

    /**
     * Searches for the top 5 largest files in the directory and displays their
     * names and sizes.
     *
     * @param path
     */
    public static void getTop5LargestFiles(Path path) {
        // Implementation
    }

    /**
     * Calculates the average file size in the given directory and displays it.
     *
     * @param path
     */
    public static void getAverageFileSize(Path path) {
        // Implementation
    }

    /**
     * Counts the number of files starting with each letter of the alphabet and
     * displays the result.
     *
     * @param path
     */
    public static void getCountFirstLetter(Path path) {
        // Implementation
    }
}
