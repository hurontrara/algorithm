package codeTree.intermediateLow.simulation.exhaustiveSearch;

import java.util.Scanner;

public class Q2 {

    public static int size;
    public static int continuous;
    public static int[][] matrix;
    public static int answer = 0;



    public static void main(String[] args) {
        
        // 인풋 받기
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        continuous = sc.nextInt();
        matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < size; row++) {
            rowSearch(row);
        }
        for (int col = 0; col < size; col++) {
            colSearch(col);
        }

        System.out.println(answer);

    }

    private static void colSearch(int col) {

        int[] colArray = new int[size];
        for (int i = 0; i < size; i++) {
            colArray[i] = matrix[i][col];
        }

        int max = 1;
        int localMax = 1;
        int value = 0;
        for (int i : colArray) {
            if (i == value) {
                localMax += 1;
                max = Math.max(localMax, max);
            } else {
                value = i;
                localMax = 1;
            }
        }

        if (max >= continuous) {
            answer += 1;
        }



    }

    private static void rowSearch(int row) {
        int[] rowArray = matrix[row];

        int max = 1;
        int localMax = 1;
        int value = 0;
        for (int i : rowArray) {
            if (i == value) {
                localMax += 1;
                max = Math.max(localMax, max);
            } else {
                value = i;
                localMax = 1;
            }
        }

        if (max >= continuous) {
            answer += 1;
        }
    }




}
