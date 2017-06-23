package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_06_String_Compression;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    private static String stringCompression(String input) {
        if (input == null || input.length() <= 2) {
            return input;
        }
        char character = input.charAt(0);
        int charsCounts = 1;
        StringBuffer compression = new StringBuffer(input.length());
        for (int index = 1; index < input.length(); index++) {
            char currentCharacter = input.charAt(index);
            if (currentCharacter == character) {
                charsCounts++;
            } else {
                compression.append(character);
                compression.append(charsCounts);
                character = currentCharacter;
                charsCounts = 1;
            }
        }
        compression.append(character);
        compression.append(charsCounts);
        String output = compression.toString();
        return output.length() < input.length() ? output : input;
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(input + " compression: " + stringCompression(input));
        input = "bc";
        System.out.println(input + " compression: " + stringCompression(input));
    }
}
