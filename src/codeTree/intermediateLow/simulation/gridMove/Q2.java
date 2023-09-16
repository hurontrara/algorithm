package codeTree.intermediateLow.simulation.gridMove;

import java.util.Scanner;

public class Q2 {

    public static int size, length, column;
    public static int[][] matrix;

    public static void main(String[] args) {
        settings();

        int row = decisionRow();

        for (int i = 0; i < length; i++) {
            matrix[row][column + i] = 1;
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int decisionRow() {

        for (int row = 0; row < size; row++) {

            for (int i = 0; i < length; i++) {

                if (matrix[row][column + i] == 1) {
                    return row - 1;
                }
            }
        }

        return size - 1;
    }

    private static boolean nonExistCheck(int saveRow) {
        return saveRow == size;
    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); length = sc.nextInt(); column = sc.nextInt() - 1; matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }


}
