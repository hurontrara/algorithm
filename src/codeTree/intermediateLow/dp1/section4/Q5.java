package codeTree.intermediateLow.dp1.section4;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {

    static int size;
    static int targetNum;
    static int[] coinList;

    static boolean[] dpMatrix;

    public static void main(String[] args) {
        setting();

        dpMatrix[0] = true;
        for (int coin : coinList) {
            dp(coin);
        }

        if (dpMatrix[targetNum])
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static void dp(int coin) {

        boolean[] savedMatrix = new boolean[targetNum + 1];
        for (int i = 0; i < targetNum + 1; i++) {
            savedMatrix[i] = dpMatrix[i];
        }


        for (int index = 1; index < targetNum + 1; index++) {

            if (existCheck(index - coin) && savedMatrix[index - coin]) {
                dpMatrix[index] = true;
            }
        }
    }


    private static boolean existCheck(int index) {
        return index >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); targetNum = sc.nextInt(); coinList = new int[size];

        for (int i = 0; i < size; i++) {
            coinList[i] = sc.nextInt();
        }

        dpMatrix = new boolean[targetNum + 1];
        dpMatrix[0] = true;


    }


}
