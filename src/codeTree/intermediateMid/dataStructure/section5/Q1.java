package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1 {

    static int n;
    static Scanner sc = new Scanner(System.in);
    static PriorityQueue<Integer> queue = new PriorityQueue<>();


    public static void main(String[] args) {
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            process();
        }

    }

    private static void process() {
        String string = sc.next();

        switch (string) {

            case "push":
                int input = sc.nextInt();
                queue.add(-input);
                break;

            case "pop":
                int popValue = queue.poll();
                System.out.println(-popValue);
                break;

            case "size":
                System.out.println(queue.size());
                break;

            case "empty":
                if (queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
                break;

            case "top":
                System.out.println(-queue.peek());
                break;


        }
    }


}
