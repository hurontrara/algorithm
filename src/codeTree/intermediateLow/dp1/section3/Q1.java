package codeTree.intermediateLow.dp1.section3;

import java.util.*;

public class Q1 {

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

        int maxValue = -1;
        for (int index = 0; index < dpMatrix.length; index++) {
            if (dpMatrix[index] > maxValue) {
                maxValue = dpMatrix[index];
            }
        }

        System.out.println(maxValue);

    }

    private static void dp(int index) {

        int localDpValue = dpMatrix[index];
        int targetValue = matrix[index];
        for (int i = 0; i < index; i++) {

            int objectValue = matrix[i];
            if (objectValue < targetValue && dpMatrix[i] + 1 > localDpValue) {
                localDpValue = dpMatrix[i] + 1;
            }

        }

        dpMatrix[index] = localDpValue;

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
