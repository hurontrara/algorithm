package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    static int size;
    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        setting();

        backTracking(0);

        System.out.println(count);
    }

    private static void backTracking(int index) {
        if (index == size) {
            count++;
            return;
        }

        if (index > size) {
            return;
        }

        for (int value = 1; value <= 4; value++) {

            for (int i = 0; i < value; i++) {
                list.add(value);
            }

            backTracking(index + value);

            for (int i = 0; i < value; i++) {
                list.remove(list.size() - 1);
            }

        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
    }


}
