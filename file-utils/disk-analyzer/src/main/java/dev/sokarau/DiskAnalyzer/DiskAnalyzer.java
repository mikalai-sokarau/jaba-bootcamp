package dev.sokarau.DiskAnalyzer;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.Map;

/**
 * Disk Analyzer class
 * Contains methods to analyze a given directory and print the results to a file
 */
public class DiskAnalyzer {
    public static final int FUNCTION_NUMBERS = 4;
    private static final String OUTPUT_FILENAME = "disk-analyzer/target/diskAnalyzerOutput.txt";

    /**
     * Searches for the file name with the maximum number of letters in the
     * name, writes a path to the file.
     *
     * @param path
     * @param letter
     */
    public static void getMaxFileByLetter(Path path, char letter) {
        try (Stream<Path> paths = Files.walk(path); FileWriter fw = new FileWriter(OUTPUT_FILENAME, true)) {
            int maxCount = 0;
            Path maxFilePath = null;
            List<Path> filePaths = new ArrayList<>(paths.collect(Collectors.toList()));

            for (Path filePath : filePaths) {
                if (Files.isRegularFile(filePath)) {
                    String fileName = filePath.getFileName().toString();
                    int count = (int) fileName.chars().filter(ch -> ch == letter).count();

                    if (count > maxCount) {
                        maxCount = count;
                        maxFilePath = filePath;
                    }
                }
            }

            if (maxFilePath != null) {
                fw.write("File with the maximum number of \"" + letter + "\" letters: " + maxFilePath + "\n");
                System.out.println("\nFile with the maximum number of \"" + letter + "\" letters: " + maxFilePath);
                System.out.println("Number of scanned files: " + filePaths.size());
            } else {
                System.out.println("No file with \"" + letter + "\" letters found.");
            }
        } catch (Exception e) {
            System.out.println("Error during scanning files:\n" + e.getMessage());
        }
    }

    /**
     * Searches for the top 5 largest files in the directory and writes their
     * names and sizes to the file.
     *
     * @param path
     */
    public static void getTop5LargestFiles(Path path) {
        try (Stream<Path> paths = Files.walk(path); FileWriter fw = new FileWriter(OUTPUT_FILENAME, true)) {
            List<Path> filePaths = paths.filter(Files::isRegularFile).collect(Collectors.toList());
            List<Path> largestFiles = filePaths.stream()
                    .sorted(Comparator.comparingLong(p -> -p.toFile().length()))
                    .limit(5)
                    .collect(Collectors.toList());

            for (int i = 0; i < largestFiles.size(); i++) {
                Path filePath = largestFiles.get(i);
                int fileSizeMb = (int) (Files.size(filePath) / 1024 / 1024);
                fw.write("File " + (i + 1) + ": " + filePath.getFileName() + ", Size: " + fileSizeMb + " MB\n");
                System.out.println("File " + (i + 1) + ": " + filePath.getFileName() + ", Size: " + fileSizeMb + " MB");
            }
            System.out.println("Number of scanned files: " + filePaths.size());
        } catch (Exception e) {
            System.out.println("Error during scanning files:\n" + e.getMessage());
        }
    }

    /**
     * Calculates the average file size in the given directory and writes it to the
     * file.
     *
     * @param path
     */
    public static void getAverageFileSize(Path path) {
        try (Stream<Path> paths = Files.walk(path); FileWriter fw = new FileWriter(OUTPUT_FILENAME, true)) {
            List<Path> filePaths = paths.filter(Files::isRegularFile).collect(Collectors.toList());

            long totalSize = 0;
            int fileCount = 0;

            for (Path filePath : filePaths) {
                totalSize += Files.size(filePath);
                fileCount++;
            }

            int averageSize = (int) (totalSize / fileCount) / 1024;
            fw.write("Average file size: " + averageSize + " KB\n");
            System.out.println("Average file size: " + averageSize + " KB");
            System.out.println("Number of scanned files: " + filePaths.size());
        } catch (Exception e) {
            System.out.println("Error during scanning files:\n" + e.getMessage());
        }
    }

    /**
     * Counts the number of files and folders starting with each letter of the
     * alphabet and writes the result to the file.
     *
     * @param path
     */
    public static void getCountFirstLetter(Path path) {
        try (Stream<Path> paths = Files.walk(path); FileWriter fw = new FileWriter(OUTPUT_FILENAME, true)) {
            List<Path> filePaths = paths.collect(Collectors.toList());
            Map<Character, Long> fileCountMap = filePaths.stream()
                    .filter(Files::isRegularFile)
                    .map(filePath -> filePath.getFileName().toString().charAt(0))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Map<Character, Long> folderCountMap = filePaths.stream()
                    .filter(Files::isDirectory)
                    .map(filePath -> filePath.getFileName().toString().charAt(0))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            for (char letter = 'A'; letter <= 'Z'; letter++) {
                long fileCount = fileCountMap.getOrDefault(letter, 0L);
                long folderCount = folderCountMap.getOrDefault(letter, 0L);

                fw.write("Number of files starting with letter " + letter + ": " + fileCount + ", folders: "
                        + folderCount + "\n");
                System.out.println("Number of files starting with letter " + letter + ": " + fileCount + ", folders: "
                        + folderCount);
            }
            System.out.println("Number of scanned files and folders: " + filePaths.size());
        } catch (Exception e) {
            System.out.println("Error during scanning files:\n" + e.getMessage());
        }
    }
}
