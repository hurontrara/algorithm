package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q9 {

    static int n, m;

    static int minValue = Integer.MAX_VALUE;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }

        for (Integer midValue : treeSet) {
            Integer lowerValue = treeSet.floor(midValue - m);

            if (lowerValue != null)
                minValue = Math.min(minValue, midValue - lowerValue);

        }

        if (minValue == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minValue);

    }


}
