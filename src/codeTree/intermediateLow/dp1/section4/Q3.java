package codeTree.intermediateLow.dp1.section4;

import java.util.Scanner;

public class Q3 {

    static int targetNum;

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 1; i < targetNum + 1; i++) {
            dp(i);
        }

        System.out.println(dpMatrix[targetNum]);
    }

    private static void dp(int index) {

        int oneDiffIndex = index - 1;
        int twoDiffIndex = index - 2;
        int fiveDiffIndex = index - 5;

        if (existCheck(oneDiffIndex)) {
            dpMatrix[index] += dpMatrix[oneDiffIndex] % 10007;
        }

        if (existCheck(twoDiffIndex)) {
            dpMatrix[index] += dpMatrix[twoDiffIndex] % 10007;
        }

        if (existCheck(fiveDiffIndex)) {
            dpMatrix[index] += dpMatrix[fiveDiffIndex] % 10007;
        }

        dpMatrix[index] %= 10007;


    }

    private static boolean existCheck(int index) {
        return index >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        targetNum = sc.nextInt();
        dpMatrix = new int[targetNum + 1];

        dpMatrix[0] = 1;
    }


}
