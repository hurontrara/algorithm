package codeTree.intermediateLow.dp2.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    static class Cloth {

        int startDay;
        int endDay;
        int exp;
        int y;

        Cloth(int startDay, int endDay, int exp, int y) {
            this.startDay = startDay;
            this.endDay = endDay;
            this.exp = exp;
            this.y = y;
        }

    }

    static int clothNum;
    static int dateNum;

    static int[][] dpMatrix;

    static List<Cloth> clothList = new ArrayList<>();
    static int[] valueList;

    public static void main(String[] args) {
        setting();

        for (int i = 2; i <= dateNum; i++) {
            dp(i);
        }

        int maxValue = 0;
        for (int i = 0; i < clothNum; i++) {
            maxValue = Math.max(dpMatrix[dateNum][i], maxValue);
        }
        System.out.println(maxValue);

    }

    private static void dp(int index) {

        for (Cloth cloth : clothList) {

            if (cloth.startDay <= index && index <= cloth.endDay) {

                int localMax = 0;
                for (Cloth frontCloth : clothList) {
                    localMax = Math.max(localMax, dpMatrix[index - 1][frontCloth.y] + Math.abs(cloth.exp - frontCloth.exp));
                }
                dpMatrix[index][cloth.y] = localMax;

            }

        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        clothNum = sc.nextInt(); dateNum = sc.nextInt();
        valueList = new int[clothNum];

        for (int i = 0; i < clothNum; i++) {
            Cloth cloth = new Cloth(sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
            clothList.add(cloth);
            valueList[i] = cloth.exp;
        }

        dpMatrix = new int[dateNum + 1][clothNum];
        for (int i = 0; i < dateNum + 1; i++) {
            for (int j = 0; j < clothNum; j++) {
                dpMatrix[i][j] = Integer.MIN_VALUE;
            }
        }

        for (Cloth cloth : clothList) {

            if (cloth.startDay == 1) {
                dpMatrix[1][cloth.y] = 0;
            }

        }



    }


}
