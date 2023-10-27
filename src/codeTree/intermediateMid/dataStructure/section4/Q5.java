package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q5 {

    static int n, m;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }

        for (int i = 0; i < n; i++) {
            treeSet.remove(sc.nextInt());
            System.out.println(treeSet.last());
        }


    }


}
