package codeTree.intermediateLow.backTracking.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    static int k, n;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        setting();

        backTracking(0, -1, 0);
    }

    private static void backTracking(int index, int value, int count) {

        if (count == 3) {
            return;
        }

        if (index == n) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= k; i++) {

            list.add(i);

            if (value == i) {
                backTracking(index + 1, value, count + 1);
            } else {
                backTracking(index + 1, i, 1);
            }

            list.remove(list.size() - 1);

        }



    }

    private static void setting() {

        Scanner sc = new Scanner(System.in);

        k = sc.nextInt(); n = sc.nextInt();

    }


}
