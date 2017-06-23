package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_07_Ratote_Matrix;

import com.mlischetti.cracking_the_coding_interview.commons.AssortedMethods;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {

    private static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                matrix[i][j] = count;
            }
        }
        AssortedMethods.printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }

}
