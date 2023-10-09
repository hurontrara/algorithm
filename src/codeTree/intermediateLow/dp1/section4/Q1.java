package codeTree.intermediateLow.dp1.section4;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    static int coinTypeNum;
    static int price;

    static int[] coinTypeArray;
    static int[] dpMatrix;


    public static void main(String[] args) {
        setting();

        dpMatrix[0] = 0;
        for (int i = 1; i < dpMatrix.length; i++) {
            dp(i);
        }

        if (dpMatrix[price] == 100000) {
            System.out.println(-1);
        }
        else {
            System.out.println(dpMatrix[price]);
        }
    }

    private static void dp(int index) {

        for (int coinType : coinTypeArray) {

            if (isInArray(index - coinType) && dpMatrix[index] > dpMatrix[index - coinType] + 1) {
                dpMatrix[index] = dpMatrix[index - coinType] + 1;
            }

        }


    }

    private static boolean isInArray(int index) {
        return (index >= 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        coinTypeNum = sc.nextInt();
        price = sc.nextInt();
        coinTypeArray = new int[coinTypeNum];

        for (int i = 0; i < coinTypeNum; i++) {
            coinTypeArray[i] = sc.nextInt();
        }

        dpMatrix = new int[price + 1];

        Arrays.fill(dpMatrix, 100000);

    }


}
