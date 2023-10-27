package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q4 {

    static class Point implements Comparable<Point> {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {

            if (this.x != point.x)
                return this.x - point.x;

            else
                return this.y - point.y;

        }


    }

    static int n, m;
    static TreeSet<Point> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            treeSet.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < m; i++) {

            Point point = new Point(sc.nextInt(), sc.nextInt());

            Point printPoint = treeSet.ceiling(point);

            if (printPoint != null)
                System.out.println(printPoint.x + " " + printPoint.y);
            else
                System.out.println(-1 + " " + -1);

        }


    }


}
