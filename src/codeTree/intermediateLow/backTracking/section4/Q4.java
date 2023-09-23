package codeTree.intermediateLow.backTracking.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    static int size;
    static int[][] matrix;

    static int[] visitedArray;

    static List<Integer> list = new ArrayList<>();

    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        setting();

        backTracking(1);

        System.out.println(minValue);


    }

    private static void backTracking(int index) {

        if (index == size) {

            list.add(0);

            int distance = 0;
            for (int i = 1; i <= size; i++) {

                int beforeValue = list.get(i - 1);
                int afterValue = list.get(i);

                int localDistance = matrix[beforeValue][afterValue];

                if (localDistance == 0) {
                    list.remove(list.size() - 1);
                    return;
                }

                distance += localDistance;
            }

            list.remove(list.size() - 1);

            if (distance < minValue) {
                minValue = distance;
            }

            return;

        }

        for (int i = 1; i < size; i++) {

            if (visitedArray[i] == 1) {
                continue;
            }

            visitedArray[i] = 1;
            list.add(i);

            backTracking(index + 1);

            list.remove(list.size() - 1);
            visitedArray[i] = 0;

        }

    }


    private static void setting() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        matrix = new int[size][size];
        visitedArray = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        visitedArray[0] = 1;
        list.add(0);

    }


}