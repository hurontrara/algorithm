package codeTree.intermediateLow.backTracking.section4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    static int size;
    static int[][] matrix;

    static boolean[] visitedList;
    static List<Integer> valueList = new ArrayList<>();

    static int globalMax = 0;


    public static void main(String[] args) {

        setting();

        backTracking(0);

        System.out.println(globalMax);


    }

    private static void backTracking(int row) {

        if (row == size) {

            int localMin = Collections.min(valueList);

            if (localMin > globalMax) {
                globalMax = localMin;
            }

            return;
        }

        for (int col = 0; col < size; col++) {

            if (visitedList[col]) {
                continue;
            }

            valueList.add(matrix[row][col]);
            visitedList[col] = true;

            backTracking(row + 1);

            visitedList[col] = false;
            valueList.remove(valueList.size() - 1);


        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        visitedList = new boolean[size];
    }
}
