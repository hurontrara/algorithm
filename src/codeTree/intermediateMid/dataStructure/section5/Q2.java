package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q2 {

    static int n, m;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        setting();

        for (int i = 0; i < m; i++) {
            process();
        }

        System.out.println(-queue.poll());

    }

    private static void process() {
        Integer actualPollValue = -queue.poll();

        queue.add((actualPollValue - 1) * -1);

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(-sc.nextInt());
        }
    }


}
