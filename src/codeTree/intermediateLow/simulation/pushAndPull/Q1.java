package codeTree.intermediateLow.simulation.pushAndPull;

import java.util.Scanner;

public class Q1 {

    public static int size;
    public static int time;
    public static int[][] matrix;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        time = sc.nextInt();
        matrix = new int[2][size];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }


        // 1초 뒤에 일어나는 일 메서드화
        for (int i = 0; i < time; i++) {
            beltProcess();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];
                System.out.print(String.valueOf(value) + ' ');
            }
            System.out.println();
        }

    }

    private static void beltProcess() {

        int upTemp = matrix[0][size - 1];
        int downTemp = matrix[1][size - 1];

        // push
        for (int i = size - 1; i > 0; i--) {
            matrix[0][i] = matrix[0][i - 1];
            matrix[1][i] = matrix[1][i - 1];
        }

        matrix[0][0] = downTemp;
        matrix[1][0] = upTemp;


    }

}
