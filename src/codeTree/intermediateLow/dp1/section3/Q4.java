package codeTree.intermediateLow.dp1.section3;

import java.util.Scanner;

public class Q4 {

    static int rowSize;
    static int colSize;
    static int[][] matrix;

    static boolean[][] canGoMatrix;
    static int[][] dpMatrix;

    public static void main(String[] args) {
        setting();

        canGoMatrixSetting();

        for (int row = 1; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                dp(row, col);
            }
        }

        int maxValue = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (dpMatrix[row][col] > maxValue)
                    maxValue = dpMatrix[row][col];
            }
        }
        System.out.println(maxValue);


    }

    private static void canGoMatrixSetting() {

        int initialValue = matrix[0][0];
        canGoMatrix[0][0] = true;

        for (int row = 1; row < rowSize; row++)
            for (int col = 1; col < colSize; col++)

                if (matrix[row][col] > initialValue)
                    canGoMatrix[row][col] = true;

    }

    private static void dp(int row, int col) {

        if (!canGoMatrix[row][col])
            return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] < matrix[row][col] && dpMatrix[i][j] + 1 > dpMatrix[row][col]) {
                    dpMatrix[row][col] = dpMatrix[i][j] + 1;
                }

            }
        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        rowSize = sc.nextInt(); colSize = sc.nextInt(); matrix = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        dpMatrix = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                dpMatrix[row][col] = 1;
            }
        }

        canGoMatrix = new boolean[rowSize][colSize];


    }


}
