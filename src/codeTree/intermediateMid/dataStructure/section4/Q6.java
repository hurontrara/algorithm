package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q6 {

    static int n;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    static int distance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        treeSet.add(0);

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();
            treeSet.add(value);

            Integer lower = treeSet.lower(value);
            Integer higher = treeSet.higher(value);

            if (lower != null)
                distance = Math.min(distance, value - lower);
            if (higher != null)
                distance = Math.min(distance, higher - value);

            System.out.println(distance);


        }


    }


}
