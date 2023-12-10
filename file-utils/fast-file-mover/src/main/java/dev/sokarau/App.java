package dev.sokarau;

import java.io.File;

import dev.sokarau.FastFileMover.FastFileMover;
import dev.sokarau.FastFileMover.FileGenarator;
import dev.sokarau.FastFileMover.PerformanceAnalyzer;

/**
 * A main class of the application.
 * It accepts 3 arguments:
 * 1. Function number
 * 2. Path to input file (or file size to generate: 1kb, 100kb, 10mb, 1gb)
 * 3. Path to output file
 *
 * Function number can be between 1 and 5
 * 1. Generate file
 * 2. Move file using file streams
 * 3. Move file using file streams with buffer size
 * 4. Move file using file channel
 * 5. Move file using NIO
 */
public class App {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Please provide paths to input and output files and the number of function");
            System.exit(0);
        }

        int methodNumber = Integer.parseInt(args[0]);

        if (methodNumber < 1 || methodNumber > FastFileMover.METHODS_NUMBER + FileGenarator.METHODS_NUMBER) {
            System.out.println("Please provide valid function number");
            System.exit(0);
        }

        if (methodNumber > 1) {
            File inputFile = new File(args[1]);

            if (!inputFile.exists()) {
                System.out.println("Input file does not exist. Please provide valid input file");
                System.exit(0);
            }
        }

        switch (methodNumber) {
            case 1:
                FileGenarator.generateFile(args[1]);
                break;
            case 2:
                PerformanceAnalyzer.analyze(() -> FastFileMover.moveFileUsingFileStreams(args[1], args[2]));
                break;
            case 3:
                PerformanceAnalyzer.analyze(() -> FastFileMover.moveFileUsingFileStreams(args[1], args[2], 100));
                break;
            case 4:
                PerformanceAnalyzer.analyze(() -> FastFileMover.moveFileUsingFileChannel(args[1], args[2]));
                break;
            case 5:
                PerformanceAnalyzer.analyze(() -> FastFileMover.moveFileUsingNio(args[1], args[2]));
                break;
        }
    }
}
