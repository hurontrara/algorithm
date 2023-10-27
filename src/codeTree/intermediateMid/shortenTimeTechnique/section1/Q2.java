package codeTree.intermediateMid.shortenTimeTechnique.section1;

import java.util.Scanner;

public class Q2 {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int k = sc.nextInt();

    static int[][] matrix = new int[n + 1][n + 1];
    static int[][] sumMatrix = new int[n + 1][n + 1];

    public static void main(String[] args) {
        setting();

        int maxValue = 0;
        for (int i = k; i < n + 1; i++) {
            for (int j = k; j < n + 1; j++) {
                int localValue = sumMatrix[i][j] - sumMatrix[i - k][j] - sumMatrix[i][j - k] + sumMatrix[i - k][j - k];
                maxValue = Math.max(maxValue, localValue);
            }
        }
        System.out.println(maxValue);

    }

    private static void setting() {

        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                sumMatrix[row][col] = sumMatrix[row - 1][col] + sumMatrix[row][col - 1] - sumMatrix[row - 1][col - 1] + matrix[row][col];
            }
        }

    }


}
