package codeTree.intermediateLow.dp1.section2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    static int size;
    static int[][] matrix;

    static int[][] minMatrix;
    static int[][] dpMatrix;

    public static void main(String[] args) {
        setting();

        dp();

        System.out.println(dpMatrix[size - 1][size - 1]);

    }

    private static void dp() {
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                int acrossMinValue = Math.max(dpMatrix[row - 1][col], dpMatrix[row][col - 1]);
                int actualValue = matrix[row][col];

                if (actualValue < acrossMinValue)
                    dpMatrix[row][col] = actualValue;
                else
                    dpMatrix[row][col] = acrossMinValue;

            }
        }
    }


    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        minMatrix = new int[size][size];
        minMatrix[0][0] = matrix[0][0];
        for (int col = 1; col < size; col++) {
            minMatrix[0][col] = Math.min(minMatrix[0][col - 1], matrix[0][col]);
        }
        for (int row = 1; row < size; row++) {
            minMatrix[row][0] = Math.min(minMatrix[row - 1][0], matrix[row][0]);
        }
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                minMatrix[row][col] = Collections.min(Arrays.asList(minMatrix[row - 1][col], minMatrix[row][col - 1], matrix[row][col]));
            }
        }



        dpMatrix = new int[size][size];
        dpMatrix[0][0] = matrix[0][0];
        for (int col = 1; col < size; col++) {
            dpMatrix[0][col] = Math.min(dpMatrix[0][col - 1], matrix[0][col]);
        }

        for (int row = 1; row < size; row++) {
            dpMatrix[row][0] = Math.min(dpMatrix[row - 1][0], matrix[row][0]);
        }


    }
}
