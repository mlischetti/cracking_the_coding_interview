package com.mlischetti.cracking_the_coding_interview.chapter_1.Q1_08_Zero_Matrix;

import com.mlischetti.cracking_the_coding_interview.commons.AssortedMethods;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0
 */

public class ZeroMatrix {

    private static void zeroMatrix(int[][] matrix) {
        boolean[] rowsZeros = new boolean[matrix.length];
        boolean[] colsZeros = new boolean[matrix[0].length];

        for (int i = 0; i < rowsZeros.length; i++) {
            for (int j = 0; j < colsZeros.length; j++) {
                if (matrix[i][j] == 0) {
                    rowsZeros[i] = true;
                    colsZeros[j] = true;
                }
            }
        }

        for (int i = 0; i < rowsZeros.length; i++) {
            // Set row to Zero
            if (rowsZeros[i]) {
                setRowToZero(matrix, i);
            }
        }
        for (int j = 0; j < colsZeros.length; j++) {
            //Set col to Zero
            if (colsZeros[j]) {
                setColumnToZero(matrix, j);
            }
        }
    }

    private static void setRowToZero(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void setColumnToZero(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(4, 4, 1, 6);
        matrix[1][2] = 0;
        AssortedMethods.printMatrix(matrix);
        zeroMatrix(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}
