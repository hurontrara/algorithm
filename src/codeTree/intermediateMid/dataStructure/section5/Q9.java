package codeTree.intermediateMid.dataStructure.section5;

import java.util.*;

public class Q9 {

    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point point) {

            if ((this.x + this.y) == (point.x + point.y))
                return this.x - point.x;

            return (this.x + this.y) - (point.x + point.y);
        }

     }

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int k = sc.nextInt();

    static TreeSet<Integer> nQueue = new TreeSet<>();
    static TreeSet<Integer> mQueue = new TreeSet<>();
    static PriorityQueue<Point> sumQueue = new PriorityQueue<>();
    static TreeSet<Point> hashSet = new TreeSet<>();

    public static void main(String[] args) {
        setting();

        sumQueue.add(new Point(nQueue.first(), mQueue.first()));
        hashSet.add(new Point(nQueue.first(), mQueue.first()));

        for (int i = 0; i < k - 1; i++) {
            process();
        }

        Point finalPoint = sumQueue.poll();

        System.out.println(finalPoint.x + finalPoint.y);



    }

    private static void process() {

        Point pollValue = sumQueue.poll();

        int localN = pollValue.x;
        int localM = pollValue.y;


        if (mQueue.higher(localM) != null) {
            Point localPoint = new Point(localN, mQueue.higher(localM));

            if (!hashSet.contains(localPoint)) {

                sumQueue.add(localPoint);
                hashSet.add(localPoint);
            }
        }

        if (nQueue.higher(localN) != null) {

            Point localPoint = new Point(nQueue.higher(localN), localM);

            if (!hashSet.contains(localPoint)) {

                sumQueue.add(localPoint);
                hashSet.add(localPoint);

            }
        }


    }

    private static void setting() {

        for (int i = 0; i < n; i++) {
            nQueue.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            mQueue.add(sc.nextInt());
        }


    }


}
