package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.Scanner;

public class Q2 {

    public static int size, n, m;
    public static int[][] matrix;

    public static int[] dx = new int[]{1, 0, 0, -1};
    public static int[] dy = new int[]{0, 1, -1, 0};


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        n = sc.nextInt() - 1; m = sc.nextInt() - 1;

        bombProcess();

        downProcess();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void downProcess() {

        for (int col = 0; col < size; col++) {

            int[] temp = new int[size];
            int index = size - 1;
            for (int row = size - 1; row >= 0; row--) {

                if (matrix[row][col] != 0) {
                    temp[index] = matrix[row][col];
                    index--;
                }

            }

            for (int row = 0; row < size; row++) {
                matrix[row][col] = temp[row];
            }

        }

    }

    private static void bombProcess() {

        int grid = matrix[n][m];
        matrix[n][m] = 0;


        for (int i = 1; i < grid; i++) {

            if (existCheck(n + i * dx[0], m + i * dy[0])) {
                matrix[n + i * dx[0]][m + i * dy[0]] = 0;
            }
            if (existCheck(n + i * dx[1], m + i * dy[1])) {
                matrix[n + i * dx[1]][m + i * dy[1]] = 0;
            }
            if (existCheck(n + i * dx[2], m + i * dy[2])) {
                matrix[n + i * dx[2]][m + i * dy[2]] = 0;
            }
            if (existCheck(n + i * dx[3], m + i * dy[3])) {
                matrix[n + i * dx[3]][m + i * dy[3]] = 0;
            }



        }

    }

    private static boolean existCheck(int i, int j) {

        return i >= 0 && i < size && j >= 0 && j < size;

    }


}
