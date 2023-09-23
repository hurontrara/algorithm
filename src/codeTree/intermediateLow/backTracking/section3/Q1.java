package codeTree.intermediateLow.backTracking.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    static int n, m;
    static int[] matrix;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        setting();

        backTracking(1,0);


    }

    private static void backTracking(int val, int index) {

        if (index == m) {

            int count = 0;
            for (int i : matrix) {
                if (i > 0) {
                    count++;
                }
            }

            if (count == m) {
                for (Integer i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }

            return;


        }

        for (int value = val; value <= n ; value++) {

            matrix[value - 1] += 1;

            list.add(value);

            backTracking(value + 1, index + 1);

            list.remove(list.size() - 1);

            matrix[value - 1] -= 1;
        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        matrix = new int[n];
    }

}
