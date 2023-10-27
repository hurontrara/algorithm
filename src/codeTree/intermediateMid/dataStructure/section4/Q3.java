package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q3 {

    static int n, m;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            Integer value = treeSet.ceiling(sc.nextInt());

            if (value != null)
                System.out.println(value);
            else
                System.out.println(-1);
        }
    }


}
