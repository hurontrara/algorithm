package codeTree.intermediateLow.backTracking.section2;

import java.util.Scanner;

public class Q3 {

    static int size;

    static int[][] valueMatrix;
    static int[][] dirMatrix;

    static int presentRow;
    static int presentCol;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int maxCount = 0;

    public static void main(String[] args) {
        setting();

        backTracking(presentRow, presentCol, 0);

        System.out.println(maxCount);
    }

    private static void backTracking(int row, int col, int count) {

        int value = valueMatrix[row][col];
        int dir = dirMatrix[row][col];
        for (int weight = 1; weight < size; weight++) {

            int postRow = row + weight * dx[dir];
            int postCol = col + weight * dy[dir];

            if (existCheck(postRow, postCol) && valueMatrix[postRow][postCol] > value) {
                backTracking(postRow, postCol, count + 1);
            }

        }

        if (count > maxCount) {
            maxCount = count;
        }




    }

    private static boolean existCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); valueMatrix = new int[size][size]; dirMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                valueMatrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dirMatrix[i][j] = sc.nextInt() - 1;
            }
        }

        presentRow = sc.nextInt() - 1;
        presentCol = sc.nextInt() - 1;


    }
}
