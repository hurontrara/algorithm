package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    public static int size, count;
    public static int[][] matrix;
    public static int[] columns;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {

        settings();

        for (int column : columns) {

            int row = findRow(column);

            if (row != -1) {
                boomProcess(row, column);
                sortProcess();
            }



        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }




    }

    private static void sortProcess() {

        // 열로서의 접근 (격자로서의 접근(dx, dy) 아님)


        for (int col = 0; col < size; col++) {

            List<Integer> zeroArray = new ArrayList<>();
            List<Integer> nonZeroArray = new ArrayList<>();

            for (int row = 0; row < size; row++) {
                if (matrix[row][col] == 0) {
                    zeroArray.add(0);
                } else {
                    nonZeroArray.add(matrix[row][col]);
                }
            }

            zeroArray.addAll(nonZeroArray);

            for (int row = 0; row < size; row++) {
                matrix[row][col] = zeroArray.get(row);
            }

        }

    }

    private static void boomProcess(int row, int column) {

        int value = matrix[row][column];

        matrix[row][column] = 0;
        for (int range = 1; range < value; range++) {
            for (int dir = 0; dir < 4; dir++) {
                if (existCheck(row + (range * dx[dir]), column + (range * dy[dir]))) {
                    matrix[row + (range * dx[dir])][column + (range * dy[dir])] = 0;
                }
            }
        }

    }

    private static boolean existCheck(int i, int j) {
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

    private static int findRow(int column) {

        for (int i = 0; i < size; i++) {
            if (matrix[i][column] != 0) {
                return i;
            }
        }

        return -1;

    }

    private static void settings() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size]; count = sc.nextInt(); columns = new int[count];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < count; i++) {
            columns[i] = sc.nextInt() - 1;
        }

    }


}
