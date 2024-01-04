package dev.sokarau;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        String mode = null;

        if (args.length > 0) {
            mode = args[0];
        } else {
            throw new IllegalArgumentException("Mode parameter is missing");
        }

        if (!mode.equals("console") && !mode.equals("file")) {
            throw new IllegalArgumentException("Invalid mode parameter");
        }
    }
}
