package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q6 {

    static Scanner sc = new Scanner(System.in);

    static int n;

    static PriorityQueue<Integer> queue = new PriorityQueue<>();


    public static void main(String[] args) {
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(-sc.nextInt());
        }

        process();

        if (queue.size() == 1)
            System.out.println(-queue.poll());
        else
            System.out.println(-1);

    }

    private static void process() {

        while (queue.size() >= 2) {

            int firstActualValue = -queue.poll();
            int secondActualValue = -queue.poll();

            int diff = Math.abs(firstActualValue - secondActualValue);

            if (diff == 0) {
                continue;
            }
            else {
                queue.add(-diff);
            }

        }


    }


}
