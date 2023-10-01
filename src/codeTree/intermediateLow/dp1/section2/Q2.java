package codeTree.intermediateLow.dp1.section2;

import java.util.Scanner;

public class Q2 {

    static int size;
    static int[][] matrix;
    static int[][] dpMatrix;

    public static void main(String[] args) {
        setting();

        dp();


    }

    private static void dp() {

        for (int row = 1; row < size; row++) {
            for (int col = size - 2; col >= 0; col--) {
                dpMatrix[row][col] = Math.min(dpMatrix[row - 1][col] + matrix[row][col], dpMatrix[row][col + 1] + matrix[row][col]);
            }
        }

        System.out.println(dpMatrix[size - 1][0]);

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

        dpMatrix = new int[size][size];
        dpMatrix[0][size - 1] = matrix[0][size - 1];

        for (int col = size - 2; col >= 0; col--) {
            dpMatrix[0][col] = dpMatrix[0][col + 1] + matrix[0][col];
        }

        for (int row = 1; row < size; row++) {
            dpMatrix[row][size - 1] = dpMatrix[row - 1][size - 1] + matrix[row][size - 1];
        }


    }


}
