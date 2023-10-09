package codeTree.intermediateLow.dp1.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q7 {

    static class Stick {
        int length;
        int value;

        Stick(int length, int value) {
            this.length = length;
            this.value = value;

        }
    }

    static int size;

    static List<Stick> stickList = new ArrayList<>();

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 1; i < size + 1; i++) {
            dp(i);
        }

        int maxValue = 0;
        for (int dpValue : dpMatrix) {
            maxValue = Math.max(maxValue, dpValue);
        }
        System.out.println(maxValue);

    }

    private static void dp(int index) {

        dpMatrix[index] = dpMatrix[index - 1];

        for (Stick stick : stickList) {

            int beforeIndex = index - stick.length;
            if (existCheck(beforeIndex) && dpMatrix[beforeIndex] + stick.value > dpMatrix[index]) {
                dpMatrix[index] = dpMatrix[beforeIndex] + stick.value;
            }

        }

    }

    private static boolean existCheck(int index) {

        return index >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 1; i <= size; i++) {
            stickList.add(new Stick(i, sc.nextInt()));
        }

        dpMatrix = new int[size + 1];


    }


}
