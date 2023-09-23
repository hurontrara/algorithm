package codeTree.intermediateLow.backTracking.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    static int n, m;
    static int[] matrix;

    static List<Integer> list = new ArrayList<>();

    static int maxValue = 0;
    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        System.out.println(maxValue);
    }

    private static void backTracking(int index, int count) {

        if (count == m) {

            int value = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                value ^= list.get(i);
            }

            if (value > maxValue) {
                maxValue = value;
            }

            return;

        }

        for (int i = index; i < n; i++) {

            list.add(matrix[i]);

            backTracking(i + 1, count + 1);

            list.remove(list.size() - 1);
        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        matrix = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextInt();
        }
    }
}
