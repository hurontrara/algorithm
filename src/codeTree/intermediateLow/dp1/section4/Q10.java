package codeTree.intermediateLow.dp1.section4;


import java.util.Scanner;

public class Q10 {

    static int size;
    static int[] numList;

    static int sumValue = 0;

    static int[][] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 1; i < numList.length + 1; i++) {
            dp(i);
        }

        System.out.println(dpMatrix[numList.length][sumValue]);


    }

    private static void dp(int index) {

        int localValue = numList[index - 1];

        for (int col = 0; col < sumValue * 2 + 1; col++) {

            int postLeftCol = col - localValue;
            int postRightCol = col + localValue;

            if (dpMatrix[index - 1][col] != -1) {
                dpMatrix[index][col] = Math.max(dpMatrix[index - 1][col], dpMatrix[index][col]);
            }

            if (dpMatrix[index - 1][col] != -1 && existCheck(postLeftCol)) {
                dpMatrix[index][postLeftCol] = Math.max(dpMatrix[index - 1][col], dpMatrix[index][postLeftCol]);
            }

            if (dpMatrix[index - 1][col] != -1 && existCheck(postRightCol)) {
                dpMatrix[index][postRightCol] = Math.max(dpMatrix[index - 1][col] + localValue, dpMatrix[index][postLeftCol]);
            }


        }



    }

    private static boolean existCheck(int col) {
        return col >= 0 && col < sumValue * 2 + 1;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        numList = new int[size];

        for (int i = 0; i < size; i++) {
            numList[i] = sc.nextInt();
            sumValue += numList[i];
        }

        dpMatrix = new int[numList.length + 1][sumValue * 2 + 1];
        for (int i = 0; i < numList.length + 1; i++) {
            for (int j = 0; j < sumValue * 2 + 1; j++) {
                dpMatrix[i][j] = -1;
            }
        }
        dpMatrix[0][sumValue] = 0;


    }


}