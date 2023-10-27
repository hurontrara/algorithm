package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q12 {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            process();
        }

    }

    private static void process() {

        queue.add(sc.nextInt());

        if (queue.size() < 3) {
            System.out.println(-1);
            return;
        }

        int firstValue = queue.poll();
        int secondValue = queue.poll();
        int thirdValue = queue.poll();

        System.out.println((long) firstValue * (long) secondValue * (long) thirdValue);

        queue.add(firstValue);
        queue.add(secondValue);
        queue.add(thirdValue);



    }


}
