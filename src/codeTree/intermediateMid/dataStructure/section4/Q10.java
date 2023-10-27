package codeTree.intermediateMid.dataStructure.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Q10 {

    static class Point implements Comparable<Point> {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.x == point.x)
                return this.y - point.y;
            else
                return this.x - point.x;
        }


    }


    static int n, m;
    static Scanner sc = new Scanner(System.in);

    static TreeSet<Point> pointList = new TreeSet<>();

    public static void main(String[] args) {
        setting();

        for (int i = 0; i < m; i++) {

            int value = sc.nextInt();
            deleteAndPrintProcess(value);

        }

    }

    private static void deleteAndPrintProcess(int value) {

        Point point = pointList.ceiling(new Point(value, -1));

        if (point != null) {
            System.out.println(point.x + " " + point.y);
            pointList.remove(point);
        }

        else
            System.out.println(-1 + " " + -1);



    }

    private static void setting() {
        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            pointList.add(new Point(sc.nextInt(), sc.nextInt()));
        }

    }


}
