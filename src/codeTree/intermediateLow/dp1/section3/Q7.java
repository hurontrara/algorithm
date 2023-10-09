package codeTree.intermediateLow.dp1.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q7 {

    static class Alba {
        int x;
        int y;
        int value;

        Alba(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

    }

    static int size;
    static List<Alba> albaList = new ArrayList<>();

    static int[] dpMatrix;


    public static void main(String[] args) {
        setting();

        albaList.sort((alba1, alba2) -> alba1.x - alba2.x);
        dpMatrix[0] = albaList.get(0).value;

        for (int i = 1; i < size; i++) {
            dp(i);
        }

        int maxValue = 0;
        for (int i = 0; i < size; i++) {
            maxValue = Math.max(dpMatrix[i], maxValue);
        }
        System.out.println(maxValue);


    }

    private static void dp(int index) {

        Alba alba = albaList.get(index);
        dpMatrix[index] = alba.value;

        for (int i = 0; i < index; i++) {

            Alba beforeAlba = albaList.get(i);
            if (dpMatrix[i] + alba.value > dpMatrix[index] && beforeAlba.y < alba.x) {
                dpMatrix[index] = dpMatrix[i] + alba.value;
            }

        }



    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            albaList.add(new Alba(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));

        }

        dpMatrix = new int[size];

    }
}
