package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_02_Check_Permutation;

import java.util.Arrays;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {

    private static String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean checkPermutation(String str1, String str2) {
        return sort(str1).equals(sort(str2));
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "dce";
        String str3 = "cba";

        System.out.println(str1 + " is permutation of " + str2 + " : " + checkPermutation(str1, str2));
        System.out.println(str1 + " is permutation of " + str3 + " : " + checkPermutation(str1, str3));
    }
}
