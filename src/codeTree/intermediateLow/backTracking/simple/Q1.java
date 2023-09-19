package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    public static int k, n;
    public static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        setting();

        backTracking(0);

    }

    private static void backTracking(int index) {

        if (index == n) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        for (int value = 1; value <= k; value++) {
            list.add(value);
            backTracking(index + 1);
            list.remove(list.size() - 1);
        }



    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); n = sc.nextInt();
    }


}
