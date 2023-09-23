package codeTree.intermediateLow.backTracking.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    static int size;
    static int[][] matrix;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int maxValue = 0;

    public static void main(String[] args) {
        setting();

        backTracking(0);

        System.out.println(maxValue);

    }

    private static void backTracking(int index) {

        if (index == size) {

            int total = 0;
            for (int i = 0; i < size; i++) {
                total += matrix[i][list.get(i)];
            }

            if (total > maxValue) {
                maxValue = total;
            }

            return;

        }

        for (int i = 0; i < size; i++) {

            if (visited[i]) continue;

            list.add(i);
            visited[i] = true;

            backTracking(index + 1);

            list.remove(list.size() - 1);
            visited[i] = false;

        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size][size];
        visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }



    }


}
