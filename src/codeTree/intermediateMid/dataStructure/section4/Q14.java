package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q14 {

    static int n, m;

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {

            int input = sc.nextInt();

            Integer floor = treeSet.floor(input);
            if (floor != null) {
                System.out.println(floor);
                treeSet.remove(floor);
            }
            else
                System.out.println(-1);


        }


    }


}
