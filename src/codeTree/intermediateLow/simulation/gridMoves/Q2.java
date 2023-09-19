package codeTree.intermediateLow.simulation.gridMoves;

import java.util.Scanner;

public class Q2 {

    public static int size, turn;
    public static int[][] matrix;

    public static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) {
        settings();


        for (int t = 0; t < turn; t++) {

            for (int num = 1; num <= Math.pow(size, 2); num++) {
                changeLogic(num);
            }

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void changeLogic(int num) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (matrix[row][col] == num) {
                    changeGrid(row, col);
                    return;
                }



            }
        }

    }

    private static void changeGrid(int row, int col) {

        int value = 0;
        int finalDir = -1;
        for (int dir = 0; dir < 8; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existenceCheck(postRow, postCol) && matrix[postRow][postCol] > value) {
                value = matrix[postRow][postCol];
                finalDir = dir;
            }

        }

        int temp = matrix[row][col];
        matrix[row][col] = matrix[row + dx[finalDir]][col + dy[finalDir]];
        matrix[row + dx[finalDir]][col + dy[finalDir]] = temp;

    }

    private static boolean existenceCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); turn = sc.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }


}
