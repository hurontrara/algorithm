package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q8 {

    static int n, m;

    static TreeSet<Integer> treeSet = new TreeSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Integer floorValue = treeSet.floor(value);

            if (floorValue != null)
                treeSet.remove(floorValue);
            else {
                System.out.println(i);
                System.exit(0);
            }

        }

        System.out.println(n);

    }
}
