package codeTree.intermediateLow.backTracking.section2;

import java.util.Scanner;

public class Q2 {

    static int moveNum, length, objectNum;

    static int[] moveArray;
    static int[] objectArray;

    static int maxCount = 0;
    public static void main(String[] args) {
        setting();

        backTracking(0);

        System.out.println(maxCount);
    }

    private static void backTracking(int index) {

        if (index == moveArray.length) {

            int localCount = 0;
            for (int object : objectArray) {
                if (object >= length - 1) {
                    localCount++;
                }
            }
            if (localCount > maxCount) {
                maxCount = localCount;
            }

            return;
        }

        for (int i = 0; i < objectArray.length; i++) {

            objectArray[i] += moveArray[index];

            backTracking(index + 1);

            objectArray[i] -= moveArray[index];
        }

    }

    private static void setting() {

        Scanner sc = new Scanner(System.in);

        moveNum = sc.nextInt(); length = sc.nextInt(); objectNum = sc.nextInt();
        moveArray = new int[moveNum];
        objectArray = new int[objectNum];

        for (int i = 0; i < moveNum; i++) {
            moveArray[i] = sc.nextInt();
        }
    }


}
