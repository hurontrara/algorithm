package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q3 {

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

        int input = sc.nextInt();

        if (input == 0) {

            Integer pollValue = queue.poll();

            if (pollValue == null)
                System.out.println(0);
            else
                System.out.println(pollValue);

        }
        else
            queue.add(input);

    }
}
