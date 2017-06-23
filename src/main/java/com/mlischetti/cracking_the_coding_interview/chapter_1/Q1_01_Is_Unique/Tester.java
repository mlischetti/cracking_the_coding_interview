package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_01_Is_Unique;

public class Tester {

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "paddle"};
        for (String word : words) {
            boolean wordA = IsUnique.isUniqueChars(word);
            boolean wordB = QuestionB.isUniqueChars(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }
    }
}
