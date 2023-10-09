package codeTree.intermediateLow.dp1.section4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q11 {

    static class Quest {
        int exp;
        int time;

        Quest(int exp, int time) {
            this.exp = exp;
            this.time = time;
        }
    }

    static int size;
    static int needExp;

    static int expSum = 0;

    static int[] dpMatrix;

    static List<Quest> questList = new ArrayList<>();

    public static void main(String[] args) {
        setting();

        for (Quest quest : questList) {
            dp(quest);
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = needExp; i < dpMatrix.length; i++) {
            minValue = Math.min(minValue, dpMatrix[i]);
        }

        if (minValue == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minValue);

    }

    private static void dp(Quest quest) {

        int[] savedMatrix = new int[dpMatrix.length];
        for (int i = 0; i < dpMatrix.length; i++) {
            savedMatrix[i] = dpMatrix[i];
        }

        for (int i = 1; i < dpMatrix.length; i++) {

            int frontIndex = i - quest.exp;

            if (existCheck(frontIndex) && savedMatrix[frontIndex] != Integer.MAX_VALUE) {
                dpMatrix[i] = Math.min(dpMatrix[i], savedMatrix[frontIndex] + quest.time);
            }


        }


    }

    private static boolean existCheck(int index) {
        return index >= 0;
    }


    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); needExp = sc.nextInt();

        for (int i = 0; i < size; i++) {

            int exp = sc.nextInt();
            int time = sc.nextInt();

            expSum += exp;

            questList.add(new Quest(exp, time));
        }

        dpMatrix = new int[expSum + 1];
        Arrays.fill(dpMatrix, Integer.MAX_VALUE);
        dpMatrix[0] = 0;

    }


}
