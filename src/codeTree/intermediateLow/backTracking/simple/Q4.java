package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    static int num;
    static List<Integer> startList = new ArrayList<>();
    static List<Integer> endList = new ArrayList<>();

    static List<Integer> localStartList = new ArrayList<>();
    static List<Integer> localEndList = new ArrayList<>();

    static int[] memoryArray = new int[1000];

    static int maxCount = 0;


    public static void main(String[] args) {
        setting();

        for (int i = 1; i <= num; i++) {
            backTracking(0, i);
        }

        System.out.println(maxCount);

    }

    private static void backTracking(int index, int maxNum) {


        if (index == maxNum) {

            List<Integer> stackedStartList = new ArrayList<>();
            List<Integer> stackedEndList = new ArrayList<>();
            int localCount = 0;

            for (int i = 0; i < localStartList.size(); i++) {
                int localStart = localStartList.get(i);
                int localEnd = localEndList.get(i);


                for (int idx = 0; idx < stackedStartList.size(); idx++) {
                    int stackedStart = stackedStartList.get(idx);
                    int stackedEnd = stackedEndList.get(idx);

                    if (!(localEnd < stackedStart || localStart > stackedEnd)) {
                        return;
                    }
                }

                stackedStartList.add(localStart);
                stackedEndList.add(localEnd);
                localCount++;

            }

            if (localCount > maxCount) {
                maxCount = localCount;
            }

            return;

        }

        for (int i = index; i < num; i++) {
            localStartList.add(startList.get(i));
            localEndList.add(endList.get(i));

            backTracking( i + 1, maxNum);

            localStartList.remove(localStartList.size() - 1);
            localEndList.remove(localEndList.size() - 1);
        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            startList.add(sc.nextInt() - 1);
            endList.add(sc.nextInt() - 1);
        }
    }


}

