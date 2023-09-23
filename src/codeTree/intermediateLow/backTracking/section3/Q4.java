package codeTree.intermediateLow.backTracking.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    static int size;
    static List<Integer> fullList = new ArrayList<>();
    static List<Integer> localList = new ArrayList<>();
    static int minValue = Integer.MAX_VALUE;


    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        System.out.println(minValue);


    }

    private static void backTracking(int index, int count) {

        if (count == size / 2) {
            List<Integer> restList = new ArrayList<>(fullList);

            for (Integer integer : localList) {
                restList.remove(integer);
            }

            int restListCount = 0;
            for (Integer integer : restList) {
                restListCount += integer;
            }

            int localListCount = 0;
            for (Integer integer : localList) {
                localListCount += integer;
            }

            int value = Math.abs(localListCount - restListCount);
            if (value < minValue) {
                minValue = value;
            }

            if (value == 1) {
                return;
            }

            restList.clear();

            return;

        }

        for (int i = index; i < size; i++) {

            localList.add(fullList.get(i));

            backTracking(i + 1, count + 1);

            localList.remove(localList.size() - 1);


        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt() * 2;
        for (int i = 0; i < size; i++) {
            fullList.add(sc.nextInt());
        }
    }


}
