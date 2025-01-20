package com.melvinnunes.mozambique.infrastructure.util;

public class StringFormatter {
    public static String capitalizeFirstLetters(String input) {
        // Split the input string into words using a regex to handle spaces and punctuation
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize the first character and append the rest of the word
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
            }
            result.append(" "); // Add a space between words
        }

        // Trim to remove the trailing space
        return result.toString().trim();
    }
}
