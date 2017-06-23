package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_03_URLify;

import com.mlischetti.cracking_the_coding_interview.commons.AssortedMethods;

import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class UrlLify {

    public static void urlify(char[] chars, int trueLength) {
        int spacesCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spacesCount++;
            }
        }
        int length = trueLength + spacesCount * 2;
        if (length != chars.length) {
            throw new InvalidParameterException("Invalid chars length. Not enough whitespaces.");
        }
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                queue.add('%');
                queue.add('2');
                queue.add('0');
            } else {
                queue.add(c);
            }
            chars[i] = queue.poll();
        }
    }

    // Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    private static int findLastCharacter(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] chars = str.toCharArray();
        int length = findLastCharacter(chars) + 1;
        urlify(chars, length);
//        replaceSpaces(chars, length);
        System.out.println("\"" + AssortedMethods.charArrayToString(chars) + "\"");
    }
}
