package codeTree.intermediateLow.dp1.section4;

import java.util.Scanner;

public class Q9 {

    static int size;
    static int[] numList;

    static int sumValue;
    static boolean[] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int coin : numList) {
            dp(coin);
        }

        for (int i = dpMatrix.length - 1; i > 0; i--) {
            if (dpMatrix[i]) {
                System.out.println(sumValue - 2 * i);
                System.exit(0);
            }
        }

    }

    private static void dp(int coin) {

        boolean[] savedMatrix = new boolean[dpMatrix.length];
        for (int i = 0; i < dpMatrix.length; i++) {
            savedMatrix[i] = dpMatrix[i];
        }


        for (int i = 1; i < dpMatrix.length; i++) {
            int frontIndex = i - coin;
            if (existCheck(frontIndex) && savedMatrix[frontIndex]) {
                dpMatrix[i] = true;
            }

        }

    }

    private static boolean existCheck(int index) {
        return index >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); numList = new int[size];

        sumValue = 0;
        for (int i = 0; i < size; i++) {
            int value = sc.nextInt();
            numList[i] = value;
            sumValue += value;
        }

        dpMatrix = new boolean[sumValue / 2 + 1];
        dpMatrix[0] = true;

    }


}
