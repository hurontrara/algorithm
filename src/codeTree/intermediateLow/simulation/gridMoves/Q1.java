package codeTree.intermediateLow.simulation.gridMoves;

import java.util.Scanner;

public class Q1 {

    public static int size, marbleNum, time;
    public static int[][] matrix;

    public static int[][] marbleMatrix;
    public static int[][] localMatrix;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {

        settings();

        for (int t = 0; t < time; t++) {

            move();

            crush();

        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (marbleMatrix[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);


    }

    private static void crush() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (marbleMatrix[i][j] >= 2) {
                    marbleMatrix[i][j] = 0;
                }
            }
        }
    }

    private static void move() {


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (marbleMatrix[row][col] == 1) {

                    setLocalMatrix(row, col);

                }

            }
        }

        // marble matrix에 복사
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                marbleMatrix[i][j] = localMatrix[i][j];
            }
        }


        // localMatrix 초기화
        localMatrix = new int[size][size];
    }

    private static void setLocalMatrix(int row, int col) {


        int max = 0;
        int maxDir = -1;
        for (int dir = 0; dir < 4; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existCheck(postRow, postCol) && matrix[postRow][postCol] > max) {
                max = matrix[postRow][postCol];
                maxDir = dir;
            }

        }

        localMatrix[row + dx[maxDir]][col + dy[maxDir]] += 1;


    }

    private static boolean existCheck(int i, int j) {
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); marbleNum = sc.nextInt(); time = sc.nextInt();
        matrix = new int[size][size];
        marbleMatrix = new int[size][size];
        localMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < marbleNum; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            marbleMatrix[row][col] = 1;
        }

    }


}
