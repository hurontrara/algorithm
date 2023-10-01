package codeTree.intermediateLow.dp1.section3;

import java.util.Scanner;

public class Q3 {

    static int size;
    static int[] matrix;

    static int[] dpMatrix;
    static boolean[] canGoMatrix;

    public static void main(String[] args) {
        setting();

        canGoMatrixSetting();

        for (int i = 1; i < size; i++) {
            dp(i);
        }


        int maxValue = 0;
        for (int i = 0; i < size; i++) {
            if (dpMatrix[i] > maxValue) {
                maxValue = dpMatrix[i];
            }
        }

        System.out.println(maxValue - 1);


    }

    private static void dp(int index) {

        if (!canGoMatrix[index]) {
            return;
        }

        for (int i = 0; i < index; i++) {

            if (i + matrix[i] >= index && dpMatrix[i] + 1 > dpMatrix[index]) {
                dpMatrix[index] = dpMatrix[i] + 1;
            }
        }

    }

    private static void canGoMatrixSetting() {

        canGoMatrix[0] = true;

        for (int i = 0; i < size; i++) {

            if (!canGoMatrix[i])
                continue;

            int value = matrix[i];
            for (int j = i + 1; j <= i + value; j++) {
                if (j < size)
                    canGoMatrix[j] = true;
            }
        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); matrix = new int[size];

        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }

        dpMatrix = new int[size];
        canGoMatrix = new boolean[size];

        for (int i = 0; i < size; i++) {
            dpMatrix[i] = 1;
        }
    }


}
