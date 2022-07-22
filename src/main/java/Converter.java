import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Converter {
    // Convert a string to camel case
    private static String convertToCamelCase(String input) {
        String[] words = input.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0) {
                word = word.isEmpty() ? word : word.toLowerCase();
            } else if (!word.equals(word.toUpperCase())) {
                word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            builder.append(word);
        }
        return builder.toString();
    }

    // Parse the first integers
    private static int parseInt(String input) {
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
            } else {
                break;
            }
        }

        return result;
    }

    private static String convert(String input) {
        StringBuilder builder = new StringBuilder();
        int parsedInt = parseInt(input);
        // Make parsedInt 4 digits long
        String parsedIntString = String.format("%04d", parsedInt);
        // Find the index of the first character after the space
        int index = input.indexOf(' ') + 1;
        // Get the string after the space
        String afterSpace = input.substring(index);
        // Convert the string to camel case
        String camelCase = convertToCamelCase(afterSpace);
        // Append the first 4 digits of the parsedIntString to the camelCase
        builder.append(parsedIntString).append("-").append(camelCase).append(".java");

        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String fileName = convert(input);
        String FILE_NAME = "./leetcode/" + fileName;

        // Create an empty file with the name fileName in the current directory using NIO
        Path newFilePath = Paths.get(FILE_NAME);
        Files.createFile(newFilePath);
    }

    private Converter() {
    }
}