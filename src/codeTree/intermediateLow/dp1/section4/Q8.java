package codeTree.intermediateLow.dp1.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q8 {

    static class Stone {

        int weight;
        int value;

        Stone(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }


    static int stoneNum;
    static int weight;

    static List<Stone> stoneList = new ArrayList<>();

    static int[] dpMatrix;

    public static void main(String[] args) {
        setting();

        for (int i = 1; i < weight + 1; i++) {
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

        for (Stone stone : stoneList) {
            int frontIndex = index - stone.weight;
            if (existCheck(frontIndex) && dpMatrix[index] < dpMatrix[frontIndex] + stone.value) {
                dpMatrix[index] = dpMatrix[frontIndex] + stone.value;
            }
        }

    }

    private static boolean existCheck(int index) {
        return index >= 0;
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        stoneNum = sc.nextInt();
        weight = sc.nextInt();

        for (int i = 0; i < stoneNum; i++) {
            stoneList.add(new Stone(sc.nextInt(), sc.nextInt()));
        }

        dpMatrix = new int[weight + 1];

    }


}
