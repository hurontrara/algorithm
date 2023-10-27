package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q7 {

    static class Number implements Comparable<Number> {

        int num;

        Number(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number numberObject) {
            return numberObject.num - this.num;
        }

    }

    static int n, k;

    static TreeSet<Number> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            treeSet.add(new Number(sc.nextInt()));
        }


        for (int i = 0; i < k; i++) {

            Number number = treeSet.first();

            System.out.print(treeSet.first().num + " ");

            treeSet.remove(treeSet.first());


        }

    }


}
