package codeTree.intermediateLow.dp1.section3;

import java.util.Scanner;

public class Q2 {

    static int size;
    static int[] matrix;

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 0; i < size; i++) {
            dpMatrix[i] = 1;
        }

        for (int i = 1; i < size; i++) {
            dp(i);
        }

        int maxValue = 0;
        for (int i = 0; i < size; i++) {
            if (dpMatrix[i] > maxValue) {
                maxValue = dpMatrix[i];
            }
        }

        System.out.println(maxValue);


    }

    private static void dp(int index) {

        int targetValue = matrix[index];

        for (int i = 0; i < index; i++) {

            int objectValue = matrix[i];

            if (objectValue > targetValue && dpMatrix[i] + 1 > dpMatrix[index]) {
                dpMatrix[index] = dpMatrix[i] + 1;
            }

        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size];

        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }

        dpMatrix = new int[size];

    }


}
