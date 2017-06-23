package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_05_OneWay;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * -------
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneWay {

    private static boolean oneWay(String strA, String strB) {
        if (strA.length() == strB.length()) {
            return checkReplaceCharacter(strA, strB);
        } else if(strA.length() + 1 == strB.length()){
            return checkAddCharacter(strA, strB);
        } else if(strA.length() == strB.length() + 1) {
            return checkAddCharacter(strB, strA);
        }
        return false;
    }

    private static boolean checkReplaceCharacter(String strA, String strB) {
        int difference = 0;
        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) != strB.charAt(i)) {
                difference++;
            }
            if (difference > 1) {
                return false;
            }
        }
        return difference == 1;
    }

    private static boolean checkAddCharacter(String strA, String strB) {
        int indexA = 0;
        int indexB = 0;
        while(indexA < strA.length() && indexB < strB.length()) {
            if(strA.charAt(indexA) != strB.charAt(indexB)) {
                if(indexA != indexB) {
                    return false;
                }
                indexB++;
            } else {
                indexA++;
                indexB++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"pale", "ple"},
                {"pale", "ate"},
                {"pales", "pale"},
                {"pale", "bale"},
                {"pale", "bake"}
        };

        for (String[] i : input) {
            String strA = i[0];
            String strB = i[1];
            System.out.println(strA + ", " + strB + " -> " + oneWay(strA, strB));
        }
    }
}
