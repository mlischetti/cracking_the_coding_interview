package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_01_Is_Unique;

import java.util.HashSet;
import java.util.Set;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public static boolean isUniqueCharsA(String word) {
        if (word.length() > 128) {
            return false;
        }
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);
            if (chars.contains(aChar)) {
                return false;
            } else {
                chars.add(aChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "paddle"};
        System.out.println("isUniqueChars: book implementation");
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }

        System.out.println("isUniqueChars: my implementation");
        for (String word : words) {
            System.out.println(word + ": " + isUniqueCharsA(word));
        }
    }
}
