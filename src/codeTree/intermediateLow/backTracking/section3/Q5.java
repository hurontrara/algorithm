package codeTree.intermediateLow.backTracking.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int size, choiceNum;

    static List<Point> pointList = new ArrayList<>();
    static List<Point> localList = new ArrayList<>();

    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        System.out.println(minValue);

    }

    private static void backTracking(int index, int count) {

        if (count == choiceNum) {

            getMinDistance();

        }

        for (int i = index; i < size; i++) {

            localList.add(pointList.get(i));

            backTracking(i + 1, count + 1);

            localList.remove(localList.size() - 1);


        }


    }

    private static void getMinDistance() {


        int localMax = Integer.MIN_VALUE;
        for (int i = 0; i < localList.size(); i++) {

            for (int j = i + 1; j < localList.size(); j++) {

                Point beforePoint = localList.get(i);
                Point afterPoint = localList.get(j);

                double distance = Math.pow(beforePoint.x - afterPoint.x, 2) + Math.pow(beforePoint.y - afterPoint.y, 2);

                if (distance > localMax) {
                    localMax = (int) distance;
                }

            }

        }
        if (localMax < minValue) {
            minValue = localMax;
        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        choiceNum = sc.nextInt();

        for (int i = 0; i < size; i++) {

            Point point = new Point(sc.nextInt(), sc.nextInt());
            pointList.add(point);

        }

    }


}
