package dev.sokarau;

import dev.sokarau.DiskAnalyzer.DiskAnalyzer;
import dev.sokarau.DiskAnalyzer.TimeTracker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main class for the Disk Analyzer application
 */
public class App {

    /**
     * @param args
     * @param args[0] path to the directory to be analyzed
     * @param args[1] function number to be executed
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java DiskAnalyzer <path> <functionNumber>\n");
            System.exit(1);
        }

        String directoryPath = args[0];
        int functionNumber = Integer.parseInt(args[1]);

        if (functionNumber < 1 || functionNumber > DiskAnalyzer.FUNCTION_NUMBERS) {
            System.out.println(
                    "Invalid function number. Please enter a number between 1 and " + DiskAnalyzer.FUNCTION_NUMBERS);
            System.exit(1);
        }

        if (functionNumber == 1 && args.length < 3) {
            System.out.println("Usage: java DiskAnalyzer <path> 1 <letter>\n");
            System.exit(1);
        }

        Path startPath = Paths.get(directoryPath);
        if (!Files.exists(startPath)) {
            System.out.println("Invalid path. Please enter a valid path");
            System.exit(1);
        }

        switch (functionNumber) {
            case 1:
                TimeTracker.track(() -> DiskAnalyzer.getMaxFileByLetter(startPath, args[2].charAt(0)));
                break;
            case 2:
                TimeTracker.track(() -> DiskAnalyzer.getTop5LargestFiles(startPath));
                break;
            case 3:
                TimeTracker.track(() -> DiskAnalyzer.getAverageFileSize(startPath));
                break;
            case 4:
                TimeTracker.track(() -> DiskAnalyzer.getCountFirstLetter(startPath));
                break;
            default:
                System.out.println("Invalid Function number");
                break;
        }
    }
}
