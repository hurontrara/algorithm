package codeTree.intermediateLow.simulation.gridMove;

import java.util.Scanner;

public class Q5 {

    public static int size, time, row, col;
    public static int[][] matrix;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] localMatrix;

    public static void main(String[] args) {

        settings();

        for (int t = 1; t <= time; t++) {
            bomb(t);
        }


        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);


    }

    private static void bomb(int time) {

        localMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                localMatrix[i][j] = matrix[i][j];
            }
        }


        int distance = (int) Math.pow(2, time - 1);

        // 모든 격자 반복
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] == 1) {

                    for (int dir = 0; dir < 4; dir++) {

                        ifExistFillOne(i, j, dir, distance);

                    }

                }

            }
        }

        matrix = localMatrix;

    }

    private static void ifExistFillOne(int i, int j, int dir, int distance) {

        int localRow = i + dx[dir] * distance;
        int localCol = j + dy[dir] * distance;

        if (!(localRow >= 0 && localRow < size && localCol >= 0 && localCol < size)) {
            return;
        }

        localMatrix[localRow][localCol] = 1;

    }

    private static void settings() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); time = sc.nextInt(); row = sc.nextInt() -1; col = sc.nextInt() - 1;
        matrix = new int[size][size];

        matrix[row][col] = 1;

    }
}
