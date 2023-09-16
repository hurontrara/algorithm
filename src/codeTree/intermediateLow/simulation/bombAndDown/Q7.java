package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.Scanner;

public class Q7 {

    public static int size;
    public static int[][] matrix;


    public static int globalMax = -1;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        settings();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {


                int[][] localMatrix = setToZero(i, j);

                int[][] gravityMatrix = gravity(localMatrix);

                checkMax(gravityMatrix);


            }
        }

        System.out.println(globalMax);



    }

    private static void checkMax(int[][] gravityMatrix) {


        int localMax = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                int value = gravityMatrix[row][col];
                if (value == 0) {
                    continue;
                }

                for (int dir = 0; dir < 2; dir++) {

                    if (existCheck(row + dx[dir], col + dy[dir]) && gravityMatrix[row + dx[dir]][col + dy[dir]] == value) {
                        localMax++;
                    }
                }


            }
        }

        if (localMax > globalMax) {
            globalMax = localMax;
        }

    }

    private static int[][] gravity(int[][] localMatrix) {

        for (int col = 0; col < size; col++) {

            int[] localColArray = new int[size];
            int index = size - 1;
            for (int row = size - 1; row >= 0; row--) {
                if (localMatrix[row][col] != 0) {
                    localColArray[index] = localMatrix[row][col];
                    index--;
                }
            }

            for (int row = 0; row < size; row++) {
                localMatrix[row][col] = localColArray[row];
            }



        }

        return localMatrix;

    }

    private static int[][] setToZero(int row, int col) {

        int[][] localMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                localMatrix[i][j] = matrix[i][j];
            }
        }

        int value = localMatrix[row][col];
        localMatrix[row][col] = 0;

        for (int val = 1; val < value; val++) {

            for (int dir = 0; dir < 4; dir++) {
                if (existCheck(row + val * dx[dir], col + val * dy[dir])) {

                    localMatrix[row + val * dx[dir]][col + val * dy[dir]] = 0;
                }
            }

        }

        return localMatrix;


    }

    private static boolean existCheck(int i, int j) {

        return i >= 0 && i < size && j >= 0 && j < size;

    }


    public static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

}
