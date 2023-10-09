package codeTree.intermediateLow.dp1.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

    static class Stone {

        int weight;
        int value;

        Stone(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }


    static int stoneNum;
    static int globalWeight;

    static List<Stone> stoneList = new ArrayList<>();

    static int[] dpMatrix;
    static int[] weightMatrix;
    static List<List<Integer>> stoneMatrix = new ArrayList<>();

    public static void main(String[] args) {
        setting();

        dpMatrix[0] = 0;
        weightMatrix[0] = 0;
        for (int i = 1; i < globalWeight + 1; i++) {
            dp(i);
        }

    }

    private static void dp(int index) {

        for (int i = 0; i < index; i++) {
            
        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        stoneNum = sc.nextInt();
        globalWeight = sc.nextInt();

        for (int i = 0; i < stoneNum; i++) {
            stoneList.add(new Stone(sc.nextInt(), sc.nextInt()));
        }

        dpMatrix = new int[globalWeight + 1];
        weightMatrix = new int[globalWeight + 1];
        for (int i = 0; i < globalWeight + 1; i++) {
            stoneMatrix.add(new ArrayList<>());
        }

        stoneList.sort((stone1, stone2) -> stone2.value - stone1.value);
    }


}
