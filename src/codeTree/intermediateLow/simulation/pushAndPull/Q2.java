package codeTree.intermediateLow.simulation.pushAndPull;

import java.util.Scanner;

public class Q2 {

    public static int size;
    public static int time;
    public static int[][] matrix;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); time = sc.nextInt(); matrix = new int[3][size];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < time; i++) {
            beltProcess();
        }


        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(String.valueOf(i) + ' ');
            }
            System.out.println();
        }

    }

    private static void beltProcess() {

        int upTemp = matrix[0][size - 1];
        int middleTemp = matrix[1][size - 1];
        int downTemp = matrix[2][size - 1];

        for (int row = 0; row < 3; row++) {
            for (int col = size - 1; col > 0; col--) {
                matrix[row][col] = matrix[row][col - 1];
            }
        }

        matrix[0][0] = downTemp;
        matrix[1][0] = upTemp;
        matrix[2][0] = middleTemp;
    }


}
