package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q4 {

    static class Point implements Comparable<Point> {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point point) {

            if (Math.abs(this.x) + Math.abs(this.y) == Math.abs(point.x) + Math.abs(point.y)) {

                if (this.x == point.x)
                    return this.y - point.y;
                else
                    return this.x - point.x;

            }

            return Math.abs(this.x) + Math.abs(this.y) - Math.abs(point.x) - Math.abs(point.y);

        }


    }


    static int n, m;
    static PriorityQueue<Point> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        setting();

        for (int i = 0; i < m; i++) {
            process();
        }

        Point finalPoint = queue.poll();
        System.out.println(finalPoint.x + " " + finalPoint.y);
    }

    private static void process() {

        Point pollPoint = queue.poll();

        queue.add(new Point(pollPoint.x + 2, pollPoint.y + 2));
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(new Point(sc.nextInt(), sc.nextInt()));
        }

    }


}
