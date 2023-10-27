package codeTree.intermediateMid.dataStructure.section5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Q8 {

    static class Point implements Comparable<Point> {

        int value;
        int seq;

        Point(int value, int seq) {
            this.value = value;
            this.seq = seq;
        }

        public int compareTo(Point point) {

            if (this.value == point.value)
                return this.seq - point.seq;
            else
                return this.value - point.value;

        }

    }

    static Scanner sc = new Scanner(System.in);
    static int t = sc.nextInt();

    public static void main(String[] args) {

        for (int i = 0; i < t; i++) {

            process();

            System.out.println();

        }


    }

    private static void process() {

        TreeSet<Point> treeSet = new TreeSet<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();
            arr[i] = value;

        }

        // initialSetting
        treeSet.add(new Point(arr[0], 0));
        System.out.print(arr[0] + " ");
        Point presentPoint = treeSet.first();

        // 프로세스 반복문
        for (int i = 2; i < n; i += 2) {

            int firstValue = arr[i];
            int secondValue = arr[i - 1];

            treeSet.add(new Point(secondValue, i - 1));
            treeSet.add(new Point(firstValue, i));

            boolean firstCheck = largerCheck(firstValue, presentPoint);
            boolean secondCheck = largerCheck(secondValue, presentPoint);

            if (firstCheck && secondCheck) {
                presentPoint = treeSet.higher(presentPoint);
            }
            else if (!firstCheck && !secondCheck) {
                presentPoint = treeSet.lower(presentPoint);
            }

            System.out.print(presentPoint.value + " ");

        }



    }

    private static boolean largerCheck(int object, Point presentPoint) {

        return object >= presentPoint.value;
    }


}
