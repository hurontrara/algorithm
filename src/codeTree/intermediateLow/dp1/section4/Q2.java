package codeTree.intermediateLow.dp1.section4;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    static int size;
    static int targetNum;
    static int[] matrix;

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        dpMatrix[0] = 0;
        for (int coin : matrix) {
            dp(coin);
        }

        System.out.println(dpMatrix[targetNum]);


    }

    private static void dp(int coin) {

        int[] savedMatrix = new int[targetNum + 1];
        for (int i = 0; i < targetNum + 1; i++) {
            savedMatrix[i] = dpMatrix[i];
        }

        for (int i = 1; i < targetNum + 1; i++) {

            int beforeIndex = i - coin;
            if (isExist(beforeIndex) && savedMatrix[beforeIndex] > -1) {

                if (dpMatrix[i] == -1) {
                    dpMatrix[i] = savedMatrix[beforeIndex] + 1;
                }
                else if (dpMatrix[i] > dpMatrix[beforeIndex] + 1) {
                    dpMatrix[i] = savedMatrix[beforeIndex] + 1;
                }


            }

        }

    }

    private static boolean isExist(int index) {

        return index >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); targetNum = sc.nextInt();
        matrix = new int[size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }

        dpMatrix = new int[targetNum + 1];
        Arrays.fill(dpMatrix, -1);

    }


}
