package codeTree.intermediateLow.dp1.section2;

import java.util.Scanner;

public class Q4 {

    static int size;
    static int[][] matrix;

    public static void main(String[] args) {
        setting();

        
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

    }


}
