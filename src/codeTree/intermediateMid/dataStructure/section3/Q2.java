package codeTree.intermediateMid.dataStructure.section3;

import java.util.HashSet;
import java.util.Scanner;

public class Q2 {

    static int n, m;

    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            hashSet.add(sc.nextInt());
        }

        m = sc.nextInt();

        for (int i = 0; i < m; i++) {

            int value = sc.nextInt();

            if (hashSet.contains(value))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");

        }



    }


}
