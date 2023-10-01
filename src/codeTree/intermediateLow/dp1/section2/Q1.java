package codeTree.intermediateLow.dp1.section2;

import java.util.Scanner;

public class Q1 {

    static int size;
    static int[][] matrix;
    static int[][] dpMatrix;
    static int maxValue = -1;

    public static void main(String[] args) {
        setting();

        dpProcess();

        System.out.println(maxValue);
    }

    private static void dpProcess() {
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                dpMatrix[row][col] = Math.max(dpMatrix[row - 1][col] + matrix[row][col], dpMatrix[row][col - 1] + matrix[row][col]);
                if (maxValue < dpMatrix[row][col]) {
                    maxValue = dpMatrix[row][col];
                }
            }
        }
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        dpMatrix = new int[size][size];
        dpMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < size; i++) {
            dpMatrix[i][0] = dpMatrix[i - 1][0] + matrix[i][0];
            dpMatrix[0][i] = dpMatrix[0][i - 1] + matrix[0][i];
        }

        maxValue = matrix[0][0];

    }


}
