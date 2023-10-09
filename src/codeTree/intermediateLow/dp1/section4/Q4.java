package codeTree.intermediateLow.dp1.section4;

import java.util.Arrays;
import java.util.Scanner;

public class Q4 {

    static int coinTypeNum;
    static int price;
    static int[] coinType;

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        dpMatrix[0] = 0;
        for (int i = 1; i < price + 1; i++) {
            dp(i);
        }

        System.out.println(dpMatrix[price]);

    }

    private static void dp(int index) {

        for (int coin : coinType) {

            if (existCheck(index - coin) && dpMatrix[index - coin] + 1 > dpMatrix[index] && dpMatrix[index - coin] != -1) {
                dpMatrix[index] = dpMatrix[index - coin] + 1;
            }

        }

    }

    private static boolean existCheck(int coin) {
        return coin >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        coinTypeNum = sc.nextInt(); price = sc.nextInt(); coinType = new int[coinTypeNum];
        for (int i = 0; i < coinTypeNum; i++) {
            coinType[i] = sc.nextInt();
        }

        dpMatrix = new int[price + 1];
        Arrays.fill(dpMatrix, -1);
    }

}
