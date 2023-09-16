package codeTree.intermediateLow.simulation.gridMove;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    public static int size, initialRow, initialCol;
    public static int[][] matrix;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static List<Integer> visited = new ArrayList<>();

    public static void main(String[] args) {
        settings();

        while (move());

        for (Integer integer : visited) {
            System.out.print(integer + " ");
        }

    }

    private static boolean move() {

        int value = matrix[initialRow][initialCol];
        visited.add(value);
        int finalDir = -1;

        for (int dir = 0; dir < 4; dir++) {
            if (existCheck(initialRow + dx[dir], initialCol + dy[dir])) {

                int dirValue = matrix[initialRow + dx[dir]][initialCol + dy[dir]];

                if (dirValue > value) {
                    value = dirValue;
                    finalDir = dir;
                    break;
                }
            }
        }

        if (finalDir == -1) {
            return false;
        }



        initialRow += dx[finalDir];
        initialCol += dy[finalDir];

        return true;


    }

    private static boolean existCheck(int i, int j) {
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

    private static void settings() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); initialRow = sc.nextInt() - 1; initialCol = sc.nextInt() - 1; matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }



    }

}
