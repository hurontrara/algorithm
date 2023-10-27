package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q7 {

    static Scanner sc = new Scanner(System.in);

    static int n;
    static int[] numList;

    static double maxValue = 0;
    static int total = 0;
    static int count = 1;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();



    public static void main(String[] args) {

        setting();

        for (int i = n - 3; i >= 0; i--) {

            int indexValue = numList[i];

            total += indexValue;

            queue.add(indexValue);
            Integer minValue = queue.peek();

            count++;

            double localMax = (total - minValue) / (double) count;

            maxValue = Math.max(localMax, maxValue);

        }

        System.out.println(String.format("%.2f", maxValue));


    }

    private static void setting() {

        n = sc.nextInt();
        numList = new int[n];

        for (int i = 0; i < n; i++) {
            numList[i] = sc.nextInt();
        }

        maxValue = Math.max(numList[n - 2], numList[n - 1]);
        total = numList[n - 2] + numList[n - 1];
        queue.add(numList[n - 2]);
        queue.add(numList[n - 1]);

    }


}
