package codeTree.intermediateLow.dp1.section3;

import java.util.Scanner;

public class Q6 {

    static int size;
    static int[] matrix;

    static int[] dpMatrix;
    static boolean[] decreased;

    public static void main(String[] args) {
        setting();

        for (int i = 1; i < size; i++) {
            dp(i);
        }

        int maxValue = 0;
        for (int i = 0; i < size; i++) {
            maxValue = Math.max(maxValue, dpMatrix[i]);
        }
        System.out.println(maxValue);

    }

    private static void dp(int index) {

        int savedValue = -1;
        for (int i = 0; i < index; i++) {

            if (decreased[i] && matrix[i] > matrix[index] && dpMatrix[index] < dpMatrix[i] + 1) {
                dpMatrix[index] = dpMatrix[i] + 1;
                savedValue = i;
            }

            if (!decreased[i] && dpMatrix[index] <= dpMatrix[i] + 1) {
                dpMatrix[index] = dpMatrix[i] + 1;
                savedValue = i;
            }

        }

        if (matrix[index] < matrix[savedValue])
            decreased[index] = true;

    }

    private static void setting() {

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); matrix = new int[size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }

        dpMatrix = new int[size];
        for (int i = 0; i < size; i++) {
            dpMatrix[i] = 1;
        }
        decreased = new boolean[size];

    }


}
