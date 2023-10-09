package codeTree.intermediateLow.dp1.section4;

import java.util.Scanner;

public class Q12 {

    static int size;
    static int[] numList;

    static int sumValue = 0;

    static boolean[][] dpMatrix;

    public static void main(String[] args) {
        setting();

        dpMatrix[0][sumValue] = true;
        for (int i = 1; i < numList.length + 1; i++) {
            dp(i);
        }


        if (dpMatrix[numList.length][sumValue])
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static void dp(int index) {

        int localNum = numList[index - 1];

        for (int col = 0; col < sumValue * 2 + 1; col++) {

            int frontIndex = col - localNum;
            int backIndex = col + localNum;

            if (dpMatrix[index - 1][col] && existCheck(frontIndex)) {
                dpMatrix[index][frontIndex] = true;
            }

            if (dpMatrix[index - 1][col] && existCheck(backIndex)) {
                dpMatrix[index][backIndex] = true;
            }

        }

    }

    private static boolean existCheck(int index) {
        return index >= 0 && index <= sumValue * 2;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); numList = new int[size];
        for (int i = 0; i < size; i++) {
            numList[i] = sc.nextInt();
            sumValue += numList[i];
        }

        dpMatrix = new boolean[numList.length + 1][sumValue * 2 + 1];

    }
}
