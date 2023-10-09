package codeTree.intermediateLow.dp2.section1;

import java.util.Scanner;

public class Q1 {

    static int size;
    static int[] numList;

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 1; i < dpMatrix.length; i++) {
            dpMatrix[i] = Math.max(dpMatrix[i], dpMatrix[i - 1] + dpMatrix[i]);
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < dpMatrix.length; i++) {
            maxValue = Math.max(maxValue, dpMatrix[i]);
        }
        System.out.println(maxValue);



    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); numList = new int[size];
        for (int i = 0; i < numList.length; i++) {
            numList[i] = sc.nextInt();
        }

        dpMatrix = new int[size];

        for (int i = 0; i < size; i++) {
            dpMatrix[i] = numList[i];
        }


    }


}
