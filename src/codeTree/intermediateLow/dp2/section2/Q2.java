package codeTree.intermediateLow.dp2.section2;

import java.util.Scanner;

public class Q2 {

    static int size;
    static int changeNum;

    static int[] targetArray;

    static int[][] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 2; i <= size; i++) {
            dp(i);
        }

        int maxValue = 0;
        for (int col = 0; col <= changeNum; col++) {
            maxValue = Math.max(maxValue, dpMatrix[size][col]);
        }
        System.out.println(maxValue);


    }

    private static void dp(int index) {

        for (int col = 0; col <= changeNum; col++) {

            if (dpMatrix[index - 1][col] != Integer.MIN_VALUE) {

                // 1. 밑으로 내려가는 경우
                int value = Integer.MIN_VALUE;
                for (int row = 0; row <= size; row++) {
                    if (dpMatrix[row][col] != Integer.MIN_VALUE) {
                        value = targetArray[row - 1];
                        break;
                    }
                }

                if (targetArray[index - 1] == value)
                    dpMatrix[index][col] = Math.max(dpMatrix[index][col], dpMatrix[index - 1][col] + 1);
                else
                    dpMatrix[index][col] = Math.max(dpMatrix[index][col], dpMatrix[index - 1][col]);


                // 2. 옆으로 가는 경우
                int postCol = col + 1;
                if (existCheck(postCol))
                    dpMatrix[index][postCol] = Math.max(dpMatrix[index][postCol], dpMatrix[index - 1][col] + 1);


            }

        }

    }

    private static boolean existCheck(int col) {
        return col <= changeNum;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        changeNum = sc.nextInt();

        targetArray = new int[size];
        for (int i = 0; i < size; i++) {
            targetArray[i] = sc.nextInt();
        }

        dpMatrix = new int[size + 1][changeNum + 1];
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < changeNum + 1; j++) {
                dpMatrix[i][j] = Integer.MIN_VALUE;
            }
        }
        dpMatrix[1][0] = 1;


    }
}
