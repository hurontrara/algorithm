package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q10 {

    static class Point implements Comparable<Point> {

        int value;

        Point(int value) {
            this.value = value;
        }

        public int compareTo(Point point) {

            if (Math.abs(this.value) == Math.abs(point.value)) {
                return this.value - point.value;
            }

            return Math.abs(this.value) - Math.abs(point.value);
        }

    }


    static Scanner sc = new Scanner(System.in);

    static int n = sc.nextInt();

    static PriorityQueue<Point> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            process();
        }
    }

    private static void process() {

        int input = sc.nextInt();

        if (input != 0) {
            queue.add(new Point(input));
        }
        else {

            Point pollValue = queue.poll();

            if (pollValue == null)
                System.out.println(0);
            else
                System.out.println(pollValue.value);


        }


    }


}
